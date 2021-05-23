import greenfoot.*;

/**
 * An actor that can be clicked on or dragged. This encapsulates
 * the messy business of detecting mouse actions and moving the
 * object, leaving subclasses to try to logically handle the action.
 * 
 * @author Ellen Spertus
 * @version 2
 */
public abstract class MousableActor extends Actor
{
    /**
     * Whether this mousable actor is covered. If it is covered,
     * the mouse will not act on it.
     */
    protected boolean covered = false;
    
    // These variables are used for keeping track of the state of
    // the mouse action.
    private boolean grabbed = false;
    private boolean mousing = false;

    // When a click/drag begins, startX and startY are set.
    // They enable us:
    // - to tell whether a movement was a click or a drag.
    // - to restore the actor to its original position if needed.
    private int startX;
    private int startY;
    
    /**
     * Constructs a MousableActor.
     */
    protected MousableActor()
    {
    }

    // Undoes an unsuccessful click or drag.
    private void undoMove()
    {
        setLocation(startX, startY);
    }

    private void startMousing()
    {
        mousing = true;
        startX = getX();
        startY = getY();
    }
    
    /**
     * Sets whether this card is covered. If a card is covered, it cannot be
     * clicked on or dragged.
     * 
     * @param b whether this card is covered
     */
    public void setCovered(boolean b)
    {
        covered = b;
    }

    /**
     * Handles clicks and drags of this mousable actor. At the end of a
     * click or drag, this calls {@link #handleClick()} or {@link #handleDrag()},
     * respectively.
     */
    @Override
    public final void act()
    {
        if (covered)
        {
            return;
        }
        // Check for clicks.
        if (Greenfoot.mouseClicked(this))
        {
            // If it overlaps with its original position,
            // it's a click; otherwise, it's a drag.
            int deltaX = Math.abs(getX() - startX);
            int deltaY = Math.abs(getY() - startY);
            if (deltaX < getImage().getWidth() 
                && deltaY < getImage().getHeight()) {
                if (!handleClick()) {
                    undoMove();
                }
            } else {
                if (!handleDrag()) {
                    undoMove();
                }
            }

            mousing = false;
            grabbed = false;
            return;
        }
        
        // Check for dragging.
        // Code adapted from http://www.greenfoot.org/topics/2687
        if (!grabbed && Greenfoot.mousePressed(this))
        {
            if (!mousing)
            {
                startMousing();
            }         
            grabbed = true;

            // Removing and re-adding it to the world seems to
            // put it on top, although this is undocumented and
            // thus could change.
            World world = getWorld();
            MouseInfo mi = Greenfoot.getMouseInfo();
            world.removeObject(this);
            world.addObject(this, mi.getX(), mi.getY());
            return;
        }
        if (grabbed && Greenfoot.mouseDragged(this))
        {
            if (!mousing)
            {
                startMousing();
            }     
            MouseInfo mi = Greenfoot.getMouseInfo();
            setLocation(mi.getX(), mi.getY());
            return;
        }  
    }  

    /**
     * <p>Tries to handle a click on this mousable actor. A mouse action
     * is considered to be a click if the movement is small enough that 
     * the actor's end location overlaps its start location.</p>
     * 
     * <p>It may not always be possible to handle a click; for example, 
     * the user might have clicked on a Card that cannot be removed, 
     * in which case the method should return false, so the caller knows 
     * to move the object back to its original location.</p>
     * 
     * @return true if able to handle the click, false if not
     */
    public abstract boolean handleClick();

    /**
     * <p>Tries to handle a drag of this mousable actor. A mouse action
     * is considered to be a drag if the movement is large enough that 
     * the actor's end location does not overlap its start location.</p>
     * 
     * <p>It may not always be possible to handle a drag; for example, the
     * user might have dragged a Card to an illegal location, such as onto
     * a non-empty pile, in which case the method should return false, so
     * the caller knows to move the object back to its original location.
     * 
     * @return true if able to handle the drag, false if not
     */
    public abstract boolean handleDrag();
}
