package activity6;

public interface LibraryObserver
{
	/*
	 * Callback method for when a Playable has been added to a library
	 * 
	 * @param pPlayable is the Playable to add
	 * @pre pPlayable != null
	 */
    public void playableAdded(Playable pPlayable);
    
    /*
     * Callback method for when a Playable has been removed from a library
     * 
     * @param pPlayable the Playable to remove
     */
    public void playableRemoved(Playable pPlayable);
}
