package net.androidengineer.kiosktemplate.adapters;
/**
 * Created by James Campbell for exclusive use by The Vape Queen. All rights reserved.
 */

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.androidengineer.kiosktemplate.R;
import net.androidengineer.kiosktemplate.objects.NavItem;

import java.util.List;

public class NavAdapter extends BaseAdapter {

    private List<NavItem> navItems;
    private LayoutInflater vi;

    public NavAdapter(List<NavItem> navItems, LayoutInflater inflater) {
        this.navItems = navItems;
        vi = inflater;
    }

    /**
     * Method get count of category list
     */
    @Override
    public int getCount() {
        return navItems.size();
    }

    /**
     * Method get item position
     */
    @Override
    public Object getItem(int position) {
        return navItems.get(position);
    }

    /**
     * Method get item id based on position
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Method to get custom adapter view initialized
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewItem itemAdapter;

        if (convertView == null) {
            convertView = vi.inflate(R.layout.item_navigation, null);
            itemAdapter = new ViewItem();
            itemAdapter.jImage = (ImageView) convertView.findViewById(R.id.imageViewNavItem);
            itemAdapter.jName = (TextView) convertView
                    .findViewById(R.id.textViewNavItem);
            convertView.setTag(itemAdapter);
        } else {
            itemAdapter = (ViewItem) convertView.getTag();
        }
        NavItem currentJuice = navItems.get(position);
        // Add received info to UI
        itemAdapter.jImage.setImageBitmap(currentJuice.getBitmap());
        itemAdapter.jName.setText(currentJuice.getName());

        return convertView;
    }

    private class ViewItem {
        ImageView jImage;
        TextView jName;
    }


}






