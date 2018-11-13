package com.gft.lab_rs.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gft.lab_rs.R;

/**定义菜单项类*/

/**自定义设置侧滑菜单ListView的Adapter*/
public class DrawerAdapter extends BaseAdapter{

    //存储侧滑菜单中的各项的数据
    List<TuiCoolMenuItem> MenuItems = new ArrayList<TuiCoolMenuItem>( ) ;
    //构造方法中传过来的activity
    Context context ;

    //构造方法
    public DrawerAdapter( Context context ){
        this.context = context ;

        MenuItems.add(new TuiCoolMenuItem("培养基",R.mipmap.ic_launcher)) ;
        MenuItems.add(new TuiCoolMenuItem("标准溶液",R.mipmap.ic_launcher)) ;
        MenuItems.add(new TuiCoolMenuItem("仪器记录",R.mipmap.ic_launcher)) ;
        MenuItems.add(new TuiCoolMenuItem("制样记录",R.mipmap.ic_launcher)) ;
        MenuItems.add(new TuiCoolMenuItem("设置",R.mipmap.ic_launcher)) ;

    }

    @Override
    public int getCount() {
        return MenuItems.size();
    }

    @Override
    public TuiCoolMenuItem getItem(int position) {

        return MenuItems.get(position) ;
    }

    @Override
    public long getItemId(int position) {

        return position ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView ;
        if(view == null){
            view =LayoutInflater.from(context).inflate(R.layout.menudrawer_item, parent, false);
            ((TextView) view).setText(getItem(position).menuTitle) ;
            ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(getItem(position).menuIcon, 0, 0, 0) ;
        }
        return view ;
    }

   public class TuiCoolMenuItem {
       public String menuTitle ;
       public int menuIcon ;

        //构造方法
        public TuiCoolMenuItem(String menuTitle , int menuIcon ){
            this.menuTitle = menuTitle ;
            this.menuIcon = menuIcon ;
        }

    }

}