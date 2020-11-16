# Activity 6 - Team 26

You can find the instructions for the activity [here](activityDescription.md).

## Problem 1

The observer design pattern has been implemented with the interface `LibraryObserver.java` which holds only two methods:
* playableAdded()
* playableRemoved()

The observer class `LibraryView` was added to generate a ListView of all playables in a Library instance. This extends the LibraryObserver interface.

Whenever a playable is added to a Library instance, all Observers in the aLibraryObservers attribute are updated using their implementation of `playableAdded`.

The resulting `ListView` from the LibraryView observer is rendered in the center of the `BorderPane`.

When users wish to add a song, the LibraryUI has an `EventHandler` that uses the given `selectFile` method to get the file. Then, the added `songFromSelection` method creates a song object from the file, adds the filename as the song title and returns the object to be added as a playable to the Library instance. 

The library instance updates the observers as mentioned and renders instantly. 

## Problem 2

Similar to Problem 1, an `EventHandler` is implemented for the remove button that uses the given `getSelected` method and the implemented `removePlayable` method in the Library Instance. The `getSelected` returns the Song Object being referenced in ListView. This object is passed into the `removePlayable` method in Library, which ensures that all observers registered with that instance are updated using their respective `playableRemoved` methods inherited from the `LibraryObserver` interface. 

## Problem 3

The Observer `StatusLogger` is implemented. Using TextFlow and the `newNode` method, it displays whenever a Playable is added or removed from the list view (aka whenever the inherited methods `playableAdded` or `playableRemoved` are called).

The `newNode` method creates a new `Text` object which is added to the `TextFlow` object's children and is rendered both in the `BorderPane` and the console. 