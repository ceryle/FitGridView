package co.ceryle.fitgridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;

public abstract class FitGridAdapter extends BaseAdapter {

    private Context context;
    private int columnWidth, columnHeight;
    private int gridSize;
    private int itemId;

    public FitGridAdapter(Context context) {
        this.context = context;
    }

    public FitGridAdapter(Context context, int itemId) {
        this.context = context;
        this.itemId = itemId;
    }

    public FitGridAdapter(Context context, int itemId, int gridSize) {
        this.context = context;
        this.itemId = itemId;
    }

    @Override
    public View getView(int position, View itemView, ViewGroup parent) {
        if (itemView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(itemId, parent, false);

            AbsListView.LayoutParams params = new AbsListView.LayoutParams(columnWidth, columnHeight);
            itemView.setLayoutParams(params);

            onBindView(position, itemView);
        }
        return itemView;
    }

    public abstract void onBindView(int position, View view);

    @Override
    public int getCount() {
        return gridSize;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    void setColumnHeight(int columnHeight) {
        this.columnHeight = columnHeight;
    }

    void setColumnWidth(int columnWidth) {
        this.columnWidth = columnWidth;
    }

    void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }
}
