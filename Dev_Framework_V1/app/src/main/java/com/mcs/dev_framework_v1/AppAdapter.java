//package com.mcs.dev_framework_v1;
//
///**
// * Created by james on 19/08/2016.
// */
//
//import java.util.List;
//
//import android.content.Context;
//import android.content.pm.ApplicationInfo;
//import android.content.pm.PackageManager;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//
//public class AppAdapter extends ArrayAdapter<ApplicationInfo>{
//
//    private List<ApplicationInfo> appList = null;
//    private Context context;
//    private PackageManager packageManager;
//
//    public AppAdapter(Context context, int resource,
//                      List<ApplicationInfo> objects) {
//        super(context, resource, objects);
//
//        this.context = context;
//        this.appList = objects;
//        packageManager = context.getPackageManager();
//    }
//
//    @Override
//    public int getCount(){
//        return ((null != appList) ? appList.size() : 0);
//    }
//    @Override
//    public ApplicationInfo getItem(int position){
//        return ((null != appList) ? appList.get(position): null);
//    }
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent){
//        View view = convertView;
//
//        if(null == view) {
//            LayoutInflater layoutInflater = (LayoutInflater) context
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view = LayoutInflater.inflate(R.layout.list_item, null);
//        }
//
//        ApplicationInfo data = appList.get(position);
//
//        if(null != data){
//
//        }
// //   }
//
//}
