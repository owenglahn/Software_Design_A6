package activity6;

public class StatusLogger implements ActionLogger
{
    public StatusLogger(){}
    
    public void PlayableAdded(Playable pPlayable)
    {
        System.out.println("The item: " + pPlayable + "has been added.");
    }
    public void PlayableRemoved(Playable pPlayable)
    {
        System.out.println("The item: " + pPlayable + "has been removed.");
    }
}
