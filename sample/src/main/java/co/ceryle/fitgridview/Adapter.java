package co.ceryle.fitgridview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

class Adapter extends FitGridAdapter {

    private int[] drawables = {
            R.drawable.face_1, R.drawable.face_2, R.drawable.face_3, R.drawable.face_4,
            R.drawable.face_5, R.drawable.face_6, R.drawable.face_7, R.drawable.face_8,
            R.drawable.face_9, R.drawable.face_10, R.drawable.face_11, R.drawable.face_12};

    private Context context;

    Adapter(Context context) {
        super(context, R.layout.grid_item);
        this.context = context;
    }

    @Override
    public void onBindView(final int position, View itemView) {
        ImageView iv = (ImageView) itemView.findViewById(R.id.grid_item_iv);
        iv.setImageResource(drawables[position]);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Position: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}