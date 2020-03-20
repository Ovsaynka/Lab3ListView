package com.example.lab3kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(private val context: Context,  //context which is on the page
                    private val imageModelArrayList: ArrayList<User>  //List users
) : BaseAdapter() {


    override fun getViewTypeCount(): Int {
        return count
    }

    //returns the position of items
    override fun getItemViewType(position: Int): Int {
        return position
    }

    //returns the size of list
    override fun getCount(): Int {
        return imageModelArrayList.size
    }

    //returns the position of items in array list
    override fun getItem(position: Int): Any {
        return imageModelArrayList[position]
    }

    //get item id
    override fun getItemId(position: Int): Long {
        return 0
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView: View? = convertView
        val holder: ViewHolder  //holder for item. For display info in listView

                    /*accesses all list items*/
        //if the item is empty we refer to the file with the
        // item layout for the list and write the data there
        if (convertView == null) {
            holder = ViewHolder()
            val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.user_data, null, true)

            //find user name textView
            holder.tvname = convertView!!.findViewById(R.id.userFirstNameTextView) as TextView
            //find user avatar imageView
            holder.iv = convertView.findViewById(R.id.userAvatarImageView) as ImageView

            convertView.tag = holder //for transformation item in listView
        } else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = convertView.tag as ViewHolder
        }
        //assign position for item
        holder.tvname!!.text = imageModelArrayList[position].userName
        holder.iv!!.setImageResource(imageModelArrayList[position].imageDrawable)

        return convertView    //return convert transformation item View
    }

    private inner class ViewHolder {

        var tvname: TextView? = null   //for userName
        internal var iv: ImageView? = null   //for imageUser

    }

}