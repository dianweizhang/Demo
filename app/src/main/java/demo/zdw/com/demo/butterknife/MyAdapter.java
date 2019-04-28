package demo.zdw.com.demo.butterknife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import demo.zdw.com.demo.R;

/**
 * Created by yidatec on 2018/9/19.
 *
 * Butterknife在adapter中的使用
 */

public class MyAdapter extends BaseAdapter {
    LayoutInflater inflater;

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.testlayout, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        holder.name.setText("Donkor");
        holder.job.setText("Android");
        // etc...
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.title)
        TextView name;
        @BindView(R.id.job)
        TextView job;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}