package com.tamtam.tamtaminfo;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.GregorianCalendar;

public class News {

    public GregorianCalendar date;
    public String   title;
    public String   body;
    //public String   imgSrc;
    public Bitmap   imgBit;
    public String   catName;
    public String   copyright;
    public int      catColor;

    public News(GregorianCalendar mdate, String mtitle, String mbody, Bitmap mimgBit,
                String mcatName, String mcopyright, int mcatColor) {
        date = mdate;
        title = mtitle;
        body = mbody;
        imgBit = mimgBit;
        catName = mcatName;
        copyright = mcopyright;
        catColor = mcatColor;
    }

    public static News[] getAllNews(Context ctx) {
        News[] tab = {
                new News(new GregorianCalendar(2014, 6, 4),
                        "Bouygues Bâtiment Ile-de-France : première pierre de Quadrans à Balard.",
                        ctx.getResources().getString(R.string.body_news1),
                        BitmapFactory.decodeResource(ctx.getResources(), R.drawable.news1),
                        "A LA UNE",
                        "Copyright",
                        0xff0066FF),
                new News(new GregorianCalendar(2015, 9, 14),
                        "Brézillon livre la première phase du nouveau centre de R&D d’Inergy Automotive Systems.",
                        ctx.getResources().getString(R.string.body_news2),
                        BitmapFactory.decodeResource(ctx.getResources(), R.drawable.news2),
                        "LIVRAISON",
                        "Copyright",
                        0xffCC9933),
                new News(new GregorianCalendar(2014, 10, 31),
                        "Manuel Valls visite la Philharmonie de Paris.",
                        ctx.getResources().getString(R.string.body_news3),
                        BitmapFactory.decodeResource(ctx.getResources(), R.drawable.news3),
                        "TEMPS FORTS",
                        "Copyright",
                        0xff33BB33),
                new News(new GregorianCalendar(2014, 7, 12),
                        "Sodéarif pour Züblin Immobilière livre le New Time sur l’Ile de la Jatte à Neuilly-sur-Seine (92).",
                        ctx.getResources().getString(R.string.body_news4),
                        BitmapFactory.decodeResource(ctx.getResources(), R.drawable.news4),
                        "LIVRAISON",
                        "Copyright",
                        0xffCC9933),
                new News(new GregorianCalendar(2014, 4, 11),
                        "Altarea Cogédim et Sodéarif livrent l’opération multi-produits, rue de Meaux à Paris dans le 19e.",
                        ctx.getResources().getString(R.string.body_news5),
                        BitmapFactory.decodeResource(ctx.getResources(), R.drawable.news5),
                        "LIVRAISON",
                        "Copyright",
                        0xffCC9933)
        };
        return (tab);
    }

    public static News getNewsAt(Context ctx, int position) {
        News[] tab = {
                new News(new GregorianCalendar(2014, 6, 4),
                        "Bouygues Bâtiment Ile-de-France : première pierre de Quadrans à Balard.",
                        ctx.getResources().getString(R.string.body_news1),
                        BitmapFactory.decodeResource(ctx.getResources(), R.drawable.news1),
                        "A LA UNE",
                        "Copyright",
                        0xff0066FF),
                new News(new GregorianCalendar(2015, 9, 14),
                        "Brézillon livre la première phase du nouveau centre de R&D d’Inergy Automotive Systems.",
                        ctx.getResources().getString(R.string.body_news2),
                        BitmapFactory.decodeResource(ctx.getResources(), R.drawable.news2),
                        "LIVRAISON",
                        "Copyright",
                        0xffCC9933),
                new News(new GregorianCalendar(2014, 10, 31),
                        "Manuel Valls visite la Philharmonie de Paris.",
                        ctx.getResources().getString(R.string.body_news3),
                        BitmapFactory.decodeResource(ctx.getResources(), R.drawable.news3),
                        "TEMPS FORTS",
                        "Copyright",
                        0xff33BB33),
                new News(new GregorianCalendar(2014, 7, 12),
                        "Sodéarif pour Züblin Immobilière livre le New Time sur l’Ile de la Jatte à Neuilly-sur-Seine (92).",
                        ctx.getResources().getString(R.string.body_news4),
                        BitmapFactory.decodeResource(ctx.getResources(), R.drawable.news4),
                        "LIVRAISON",
                        "Copyright",
                        0xffCC9933),
                new News(new GregorianCalendar(2014, 4, 11),
                        "Altarea Cogédim et Sodéarif livrent l’opération multi-produits, rue de Meaux à Paris dans le 19e.",
                        ctx.getResources().getString(R.string.body_news5),
                        BitmapFactory.decodeResource(ctx.getResources(), R.drawable.news5),
                        "LIVRAISON",
                        "Copyright",
                        0xffCC9933)
        };
        return (tab[position]);
    }

}
