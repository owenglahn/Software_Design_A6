# Owen Glahn's Contributions

## Problem 1
### Tester
* Wrote `testSongObserver()` in `p1_tests` https://gitlab.cs.mcgill.ca/mnassif/303a6t26/-/merge_requests/14/diffs?commit_id=d9c89aeb811a83d1fbd5c321df78de599ba4e4f4
* Fixed file naming issue in `testSongFromFileSelection()` https://gitlab.cs.mcgill.ca/mnassif/303a6t26/-/merge_requests/14/diffs?commit_id=d9c89aeb811a83d1fbd5c321df78de599ba4e4f4
## Problem 2
### Implementer
* Designed `LibraryObserver` interface and concrete implementation `LibraryView` https://gitlab.cs.mcgill.ca/mnassif/303a6t26/-/merge_requests/4
* Wrote event handling in `LibraryUI` for the selection of the "Remove Item" button in the UI [src/activity6/LibraryUI.java](https://gitlab.cs.mcgill.ca/mnassif/303a6t26/-/blob/master/src/activity6/LibraryUI.java) lines 84-90
* My merge requests were closed, but my implementations were used in a unification of Problems 2 and 3 https://gitlab.cs.mcgill.ca/mnassif/303a6t26/-/merge_requests/5 
### Tester
* Wrote test to check for proper implementation of the callback method in `LibraryView` [test/activity6/TestSongRemovedFromLib.java](https://gitlab.cs.mcgill.ca/mnassif/303a6t26/-/blob/master/test/activity6/TestSongRemovedFromLib.java)
### Reviewer
* Discussed approach for initial implementation and how to apply OBSERVER design pattern https://gitlab.cs.mcgill.ca/mnassif/303a6t26/-/issues/3
* Reviewed my initial implementation of Problem 2 https://gitlab.cs.mcgill.ca/mnassif/303a6t26/-/merge_requests/4
* Made a class diagram for how to implement OBSERVER to activity [activity6problem2_OG.PNG](https://gitlab.cs.mcgill.ca/mnassif/303a6t26/-/blob/master/activity6problem2_OG.PNG)
## Problem 3
### Implementer
* Changed `StatusLogger` to follow design of OBSERVER pattern https://gitlab.cs.mcgill.ca/mnassif/303a6t26/-/merge_requests/4
