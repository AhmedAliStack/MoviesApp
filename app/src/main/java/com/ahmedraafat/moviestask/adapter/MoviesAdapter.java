package com.ahmedraafat.moviestask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ahmedraafat.moviestask.R;
import com.ahmedraafat.moviestask.model.CateModel;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private static final String TAG = MoviesAdapter.class.getSimpleName();
    private Context mContext;
    private List<CateModel> mList;
    private OnItemClickListener mListener;

    public MoviesAdapter(Context context, List<CateModel> list, OnItemClickListener onItemClickListener) {
        this.mContext = context;
        this.mList = list;
        this.mListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.row_single_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CateModel item = mList.get(position);

        //TODO setup views
        holder.itemView.setOnClickListener(v -> {
            mListener.onItemClick(item);
            item.setExpanded(!item.isExpanded());
            notifyDataSetChanged();
        });
        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(CateModel item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //TODO Bind views
        private TextView tvTitle;
        private ImageView ivStatus;
        private RecyclerView rvMovies;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            ivStatus = itemView.findViewById(R.id.ivStatus);
            rvMovies = itemView.findViewById(R.id.rvMovies);

        }

        public void setData(CateModel item) {
            tvTitle.setText(item.title);
            ivStatus.setImageResource(item.expanded ? R.drawable.ic_expanded : R.drawable.ic_collapsed);
        }
    }
}