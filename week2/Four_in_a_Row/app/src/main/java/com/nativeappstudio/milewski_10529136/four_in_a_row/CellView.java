package com.nativeappstudio.milewski_10529136.four_in_a_row;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Display;
import android.widget.ImageView;


/**
 * Created by victor on 2-11-2015.
 */
public class CellView extends ImageView {

    int COLUMN = 0; //default
    int ROW = 0; //default
    boolean FREE = true;
    int PLAYER = 0;

    public CellView(Context context, int x, int y) {
        super(context);
        super.setImageResource(R.drawable.empty_cell);

        ROW = x;
        COLUMN = y;
    }

    public CellView(Context context) {
        super(context);
    }

    public CellView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CellView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getRow() {
        return ROW;
    }

    public int getCol() {
        return COLUMN;
    }

    public boolean isFree() {
        return FREE;
    }

    public int getPlayer() {
        return PLAYER;
    }

    public int drop(boolean player1) {
        int lastRow = ROW;
        if (player1) {
            PLAYER = 1;
            FREE = false;
            super.setImageResource(R.drawable.player1_cell);
        } else {
            PLAYER = 2;
            FREE = false;
            super.setImageResource(R.drawable.player2_cell);
        }

        if (ROW != FourRowActivity.board.getRowCount()) {
            for (CellView cell : FourRowActivity.cells) {
                int c = cell.getCol();
                int r = cell.getRow();
                if (c == COLUMN && r == ROW + 1) {
                    if(cell.isFree()) {
                        FREE = true;
                        super.setImageResource(R.drawable.empty_cell);
                        lastRow = FourRowActivity.dropCoin(COLUMN, ROW + 1);
                    }
                }
            }
        }
        return lastRow;
    }
}
