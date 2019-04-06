package com.hfad.bitsandpizzas;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder> {

    interface ClickObserver {
        void onClick(int position);
    }

    private final String[] mCaptions;
    private final int[] mImageIds;

    private final ClickObserver mClickObserver;

    CaptionedImagesAdapter(String[] captions, int[] imageIds, ClickObserver clickObserver) {
        this.mCaptions = captions;
        this.mImageIds = imageIds;
        mClickObserver = clickObserver;
    }

    @Override
    public int getItemCount() {
        return mCaptions.length;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_captioned_image, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        View itemView = holder.itemView;

        ImageView imageView = itemView.findViewById(R.id.info_image);
        // NOTE: If this was an activity or fragment, I would call getResources().getDrawable();
        Drawable drawable = ContextCompat.getDrawable(itemView.getContext(), mImageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(mCaptions[position]);

        TextView textView = itemView.findViewById(R.id.info_text);
        textView.setText(mCaptions[position]);

        // Each itemView sets a View.OnClickListener which then relays the necessary information to
        // the clickObserver. The use of the Observer pattern means that this Adapter is kept generic
        // and indeed we use the same adapter for the pizzas, the pastas AND the stores!
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClickObserver != null) {
                    // NOTE: we don't use position because it might have changed in the meantime.
                    mClickObserver.onClick(holder.getAdapterPosition());
                }
            }
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        // SOS: super(v) attaches v to the viewHolder and also stores it in the public field itemView
        // (see onBindViewHolder above). So I can retrieve it, recast it to CardView etc.
        ViewHolder(CardView v) {
            super(v);
        }
    }
}
