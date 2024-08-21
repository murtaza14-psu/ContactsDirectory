package com.example.contactsusingrecyclerview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewpagerAdapterContacts extends FragmentPagerAdapter {


    public ViewpagerAdapterContacts(@NonNull FragmentManager fm) {
        super(fm);
    }

    //This method sets the fragments on the view pager based on the position received from getCount()
    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new ContactsFragment();
        }
        else{
            return new FavouritesFragment();
        }
    }

    //no of tabs setup by theis method
    @Override
    public int getCount() {
        return 2;
    }


    //setting titles of the tabs in the top tab layout
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       if(position==0){
           return "Contacts";
       }else{
           return "Favourites";
       }
    }
}
