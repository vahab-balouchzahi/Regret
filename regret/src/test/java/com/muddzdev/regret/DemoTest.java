package com.muddzdev.regret;

import android.graphics.Color;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DemoTest {

    private UndoRedoManager undoRedoManager;
    private static final String TEXT_COLOR_RED = "TEXT_COLOR_RED";
    private static final String TEXT_COLOR_GREEN = "TEXT_COLOR_GREEN";
    private static final String BACKGROUND_COLOR_WHITE = "BACKGROUND_COLOR_WHITE";
    private static final String BACKGROUND_COLOR_BLACK = "BACKGROUND_COLOR_BLACK";


    @Before
    public void setUp() {
        undoRedoManager = new UndoRedoManager();
        undoRedoManager.add(TEXT_COLOR_RED, Color.RED);
        undoRedoManager.add(TEXT_COLOR_GREEN, Color.GREEN);
        undoRedoManager.add(BACKGROUND_COLOR_WHITE, Color.WHITE);
        undoRedoManager.add(BACKGROUND_COLOR_BLACK, Color.BLACK);
    }

    @Test
    public void testUndoRedo() {
        Assert.assertEquals(Color.WHITE, undoRedoManager.undo().getOldValue());
        Assert.assertEquals(Color.GREEN, undoRedoManager.undo().getOldValue());
        Assert.assertEquals(Color.RED, undoRedoManager.undo().getOldValue());

        Assert.assertEquals(Color.GREEN, undoRedoManager.redo().getOldValue());
        Assert.assertEquals(Color.WHITE, undoRedoManager.redo().getOldValue());
        Assert.assertEquals(Color.BLACK, undoRedoManager.redo().getOldValue());
    }

}
