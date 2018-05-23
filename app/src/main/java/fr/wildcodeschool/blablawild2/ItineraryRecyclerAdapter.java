package fr.wildcodeschool.blablawild2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ItineraryRecyclerAdapter extends RecyclerView.Adapter<ItineraryRecyclerAdapter.ViewHolder> {


    private ArrayList<ItineraryModel> mItineraries;
    private Context context;



    public ItineraryRecyclerAdapter(ArrayList<ItineraryModel> itineraries) {
        mItineraries = itineraries;

    }



    @Override
    public ItineraryRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_itinerary, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItineraryRecyclerAdapter.ViewHolder holder, int position) {
        final ItineraryModel itineraryModel = mItineraries.get(position);

        holder.tvDriver.setText(itineraryModel.getDriver());
        holder.tvDate.setText(itineraryModel.getDate().toString());
        holder.tvPrice.setText(String.valueOf(itineraryModel.getPrice()));

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(isLongClick)
                    Toast.makeText(context, "Long click"+mItineraries.get(position), Toast.LENGTH_SHORT).show();

                else
                    Toast.makeText(context, "Long click"+mItineraries.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public int getItemCount() {
        return mItineraries.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView tvDate, tvDriver, tvPrice;
        private ItemClickListener itemClickListener;

        public ViewHolder(View v) {
            super(v);
            this.tvDate = v.findViewById(R.id.tv_date);
            this.tvDriver = v.findViewById(R.id.tv_driver);
            this.tvPrice = v.findViewById(R.id.tv_price);

            v.setOnClickListener(this);
            v.setOnLongClickListener(this);

        }


        public void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {

        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }
}

