package PaooGame.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    private final boolean[] keys;

    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    public boolean esc;
    public boolean space;

    public KeyManager()
    {
        keys = new boolean[256];
    }

    public void Update()
    {
        //inainte/dreapta/stanga/space = valoarea booleana proprie
        up = keys[KeyEvent.VK_W] ||  keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_S] ||  keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_A] ||  keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_D] ||  keys[KeyEvent.VK_RIGHT];
        esc = keys[KeyEvent.VK_ESCAPE];
        space = keys[KeyEvent.VK_SPACE];

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //@Override
    public void keyPressed(KeyEvent e)
    {
        keys[e.getKeyCode()] = true;
    }

    //@Override
    public void keyReleased(KeyEvent e)
    {//tasta eliberata
        keys[e.getKeyCode()] = false;
    }


}
