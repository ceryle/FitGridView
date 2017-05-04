package co.ceryle.fitgridview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.GridView;

public class FitGridView extends GridView {
    public FitGridView(Context context) {
        super(context);
        init(null);
    }

    public FitGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public FitGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FitGridView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private int column, row;

    private void init(AttributeSet attrs) {
        getAttributes(attrs);

        setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
        setNumColumns(column);
    }

    private void getAttributes(AttributeSet attrs) {
        if (null == attrs)
            return;

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.FitGridView);

        column = typedArray.getInt(R.styleable.FitGridView_column, 0);
        row = typedArray.getInt(R.styleable.FitGridView_row, 0);

        typedArray.recycle();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        updateAndMeasure();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        remeasure(width, height);

        setMeasuredDimension(width, height);
    }

    /**
     * use it to update view if you have changed width/height, grid size or adapter.
     */
    private void updateAndMeasure() {
        if (null == fitGridAdapter)
            return;

        fitGridAdapter.setNumRows(row);
        fitGridAdapter.setNumColumns(column);
        fitGridAdapter.setColumnHeight(itemHeight);
        fitGridAdapter.setColumnWidth(itemWidth);
        setAdapter(fitGridAdapter);
    }

      public void update() {
        remeasure(getMeasuredWidth(), getMeasuredHeight());
        updateAndMeasure();
    }

    /**
     * @param displayWidth  sets max available width for grid view
     * @param displayHeight sets max available height for grid view
     */
    public void setDimension(float displayWidth, float displayHeight) {
        itemWidth = (int) displayWidth / column;
        itemHeight = (int) displayHeight / row;
        updateAndMeasure();
    }

    private int itemWidth = 0, itemHeight = 0;

    private void remeasure(int width, int height) {
        itemWidth = width / (column == 0 ? 1 : column);
        itemHeight = height / (row == 0 ? 1 : row);
    }

    /**
     * @return Number of columns associated with the view
     */
    @Override
    public int getNumColumns() {
        return column;
    }

    /**
     * @return Number of rows associated with the view
     */
    public int getNumRows() {
        return row;
    }

    /**
     * @param column sets the desired number of columns in the grid
     */
    public void setNumColumns(int column) {
        this.column = column;
        super.setNumColumns(column);
    }

    /**
     * @param row sets the desired number of row in the grid
     */
    public void setNumRows(int row) {
        this.row = row;
    }

    private FitGridAdapter fitGridAdapter;

    /**
     * @param fitGridAdapter sets adapter and measures available screen sizes to fit gridView in it.
     */
    public void setFitGridAdapter(FitGridAdapter fitGridAdapter) {
        this.fitGridAdapter = fitGridAdapter;
    }
}
