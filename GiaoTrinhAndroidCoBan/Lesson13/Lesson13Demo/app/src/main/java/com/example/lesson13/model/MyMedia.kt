package com.example.lesson13.model

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaMetadataRetriever
import android.provider.MediaStore
import android.util.Log
import androidx.core.graphics.drawable.toBitmap
import com.example.lesson13.R
import java.lang.Exception

class MyMedia(val context:Context) {

    fun getListSong():ArrayList<Song>{
        val listSong = ArrayList<Song>()
        val projection = arrayOf("title","artist","_data","album_id","duration")
        val cursor = context.contentResolver.query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            null,
            null,
            null,
            null
        )
        if(cursor!= null && cursor.moveToFirst()){
            do{
                val title = cursor.getString(cursor.getColumnIndex("title"))
                val artist = cursor.getString(cursor.getColumnIndex("artist"))
                val path = cursor.getString(cursor.getColumnIndex("_data"))
                val albumID = cursor.getString(cursor.getColumnIndex("album_id"))
                val timeTotal = cursor.getInt(cursor.getColumnIndex("duration"))
                listSong.add(Song(title, artist, path, timeTotal))
                Log.e("DEMO123","$title + $artist + $path")
            }while (cursor.moveToNext())
        }
        return listSong
    }

    fun getCoverBitMap(song: Song):Bitmap{
        val mmr = MediaMetadataRetriever()
        mmr.setDataSource(song.path)
        var bm:Bitmap? = null
        bm = try{
            val art = mmr.embeddedPicture
            BitmapFactory.decodeByteArray(art,0,art?.size?:0)
        }catch(e: Exception){
            context.resources.getDrawable(R.drawable.disc1).toBitmap()
        }
        return bm!!
    }
}