package dk.sdu.mmmi.iss.behealthy.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dk.sdu.mmmi.iss.behealthy.R;
import dk.sdu.mmmi.iss.behealthy.model.DataProvider;

public class DataProviderSelectionListAdapter extends RecyclerView.Adapter<DataProviderSelectionListAdapter.ViewHolder> {

    private DataProvider selectedDataProvider;
    private List<DataProvider> content;
    private Runnable onClick;

    public DataProviderSelectionListAdapter(DataProvider[] content, Runnable onClick) {
        this.content = new ArrayList<>(Arrays.asList(content));
        this.onClick = onClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_provider_selection_list_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(root);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        DataProvider dp = content.get(position);
        TextView dataProviderText = viewHolder.itemView.findViewById(R.id.dataProviderText);

        dataProviderText.setText(dp.getName());

        viewHolder.itemView.setOnClickListener(view -> {
            Log.d("fuck", "pressed");
            selectedDataProvider = dp;
            onClick.run();
            /*FragmentManager f = ((AppCompatActivity) context).getSupportFragmentManager();
            ConversationFragment cf = new ConversationFragment();
            Bundle bundle = new Bundle();

            bundle.putSerializable(context.getString(R.string.EXTRA_OTHER_USER), content.get(viewHolder.getAdapterPosition()).getOther());
            cf.setArguments(bundle);

            f.beginTransaction().setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(R.id.dashboardFragment, cf).addToBackStack(null).commit();*/
        });
    }

    @Override
    public int getItemCount() {
        return content.size();
    }

    public DataProvider getSelectedDataProvider() {
        return selectedDataProvider;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
