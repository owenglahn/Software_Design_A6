## Implementation 

> I contributed an implementation for **Problem 1** into the branch: [alex_problem_1](https://gitlab.cs.mcgill.ca/mnassif/303a6t26/-/tree/alex_problem_1)
>
> It was later merged into [arman_problem3_unified](https://gitlab.cs.mcgill.ca/mnassif/303a6t26/-/tree/arman_problem3_unified)

* (**dd61a76b**) This commit creates an anonymous inner class Event Handler which calls `selectFile(..)` and parses the response to create a new `Song` from it. The title of the `Song` was the filename without the extension
* (**13157925**) This commit creates the LibraryStateChangeObserver interface
  * Has methods:
  * `playableAdded(Playable pPlayable)`
  * `playableRemoved(Playable pPlayable)`
  * These are the callback methods of the Observer
* (**4478fb89**) LibraryUI implements LibraryStateChangeObserver
  * `playableAdded(Playable pPlayable)`updates the ListView with the new Playable
  * `playableRemoved(Playable pPlayable)`is a stub method for Problem 2
* (**8454fe4f**) Library now implements methods used to register and deregister LibraryStateChangeObservers
  * `registerObserver(LibraryStateChangeObserver pObserver)` adds the passed pObserver to the List aObservers
  * `deregisterObserver(LibraryStateChangeObserver pObserver)` removes the passed pObserver from the List aObservers
  * `addItem(Playable pPlayable)` iterates through Observers and calls their callback method `playableAdded(Playable pPlayable)`
  * `removeItem(Playable pPlayable)` iterates through Observers and calls their callback method `playableRemoved(Playable pPlayable)`
* (**98a99270**) and (**1b9e7dd0**) These two commits separate some logic into two methods to increase testability of code (i.e. move it away from the GUI code)
  * `songFromSelection(Optional<File> pSelected)`
  * `addSongToLibrary(Library pLibrary)`

## Review

* I reviewed @oglahn's implementation of Problem 2 (https://gitlab.cs.mcgill.ca/mnassif/303a6t26/-/issues/3#note_35192)
  * I note their good use of the Observer design pattern
  * I discuss their concern previously mentioned to me in another thread over a potential breach of encapsulation
* I also reviewed @yhan68's implementation of Problem 2 (https://gitlab.cs.mcgill.ca/mnassif/303a6t26/-/merge_requests/6#note_36234)
  * I pointed out that they forgot to add the LibraryObserver implementation to the Library
  * Also I noted that they were calling the `removeItem(..)` method on the removeButton's event handler while also calling the callback method `playableRemoved(..)`. This was unnecessary, as when the Observer is properly registered, calling `removeItem(..)` will then call `playableRemoved(..)` automatically
* I reviewed the unified code merge request (https://gitlab.cs.mcgill.ca/mnassif/303a6t26/-/merge_requests/5#note_36110)
  * I discussed whether StatusLogger needed to contain a refrence to Library

## Testing

* (**fc578db8**) and (**259d1762**) Adds two unit tests for my own implementation in p1_tests.java
  * `testSongFromSelection()`
    * tests creating a Song from a file selection
  * `testAddSongToLibrary()` 
    * tests the logic to add that created Song to the LIbrary
    * [Removed in final version since method no longer exists]
* (**5cc1b77f**) Adds tests for **Problem 3** into branch [alex_problem1_problem3_tests](https://gitlab.cs.mcgill.ca/mnassif/303a6t26/-/tree/alex_problem1_problem3_tests/test/activity6) as [p3_tests_addremove_statuslogger](https://gitlab.cs.mcgill.ca/mnassif/303a6t26/-/blob/alex_problem1_problem3_tests/test/activity6/p3_tests_addremove_statuslogger.java)
  * `testStatusLoggerAddPlayable()` tests whether adding a Playable to library calls the correct callback function in StatusLogger and adds the correct log text to it
  * `testStatusLoggerRemovePlayable()` tests the callback for removing a Playable from library and checks that the correct log text is added to StatusLogger


