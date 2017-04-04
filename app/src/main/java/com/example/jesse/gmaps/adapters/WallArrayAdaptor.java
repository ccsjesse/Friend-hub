package com.example.jesse.gmaps.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jesse.gmaps.model.Comment;
import com.example.jesse.gmaps.R;

import java.util.ArrayList;

/**
 * Created by Jesse on 3/28/2017.
 */


public class WallArrayAdaptor extends ArrayAdapter<Comment> {
    //my new class var, copies of constractor params, but add more if req
    private Context context;
    private ArrayList<Comment> theCommentArray;

    // constructor
    public WallArrayAdaptor(Context _context, int textViewResourceId, ArrayList<Comment> _theCommentArray){
        //call base class constructor
        super(_context, textViewResourceId, _theCommentArray);

        //save the context and the array of comments we were given
        context = _context;
        theCommentArray = _theCommentArray;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View wall_post = inflater.inflate (R.layout.wall_post, parent, false);

        TextView initials = (TextView) wall_post.findViewById( R.id.initials);
        initials.setText (theCommentArray.get(position).getInitials());

        TextView commentContent = (TextView) wall_post.findViewById( R.id.comments);
        commentContent.setText (theCommentArray.get(position).getContent());

        TextView time = (TextView) wall_post.findViewById( R.id.comment_time);
        time.setText (theCommentArray.get(position).getTime());

        return wall_post;
    }
}