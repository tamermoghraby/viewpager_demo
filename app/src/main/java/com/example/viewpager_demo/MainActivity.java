package com.example.viewpager_demo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.viewpager_demo.adapter.SliderAdapter;
import com.example.viewpager_demo.model.SliderItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<SliderItem> sliderItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        ViewPager2 viewPager = findViewById(R.id.viewPager);
        createItemsList();
        viewPager.setAdapter(new SliderAdapter(sliderItems, viewPager));
    }

    private void createItemsList(){

        String[] imageUrls = {
                "https://assets.stickpng.com/images/6128ffece3a15c00041a8e44.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlDQezbnNtQebOomG7eOzBrf1cNv1aFF50Pp3ynxQu&s",
                "https://upload.wikimedia.org/wikipedia/sco/thumb/d/d2/Pizza_Hut_logo.svg/2177px-Pizza_Hut_logo.svg.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9v5-bdQ4a-mEVLFMkZui0_vvLOsGafaGS8WqYLs0&s",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQSdNbbDI2a-YirqHx1HUut-XLND_EFAI7yeIxNcfY&s",
                "https://cdn.cookielaw.org/logos/94ba57b5-e5fc-4459-a91d-28bc381b6185/4d184cf0-49a3-428c-bd2a-a761d4b9a22d/9b0f8204-596e-41aa-bb2d-e929c0663932/Tacobell.comLogo.png",
                "https://prnewswire2-a.akamaihd.net/p/1893751/sp/189375100/thumbnail/entry_id/0_cxe8zcu5/def_height/2700/def_width/2700/version/100012/type/1",
                "https://upload.wikimedia.org/wikipedia/en/thumb/d/d3/Starbucks_Corporation_Logo_2011.svg/800px-Starbucks_Corporation_Logo_2011.svg.png",
                "https://seeklogo.com/images/D/dunkin-donuts-logo-1E269BA8F1-seeklogo.com.png",
                "https://i.pinimg.com/1200x/67/40/d5/6740d50dd14ff6f45d2e458942b9dc79.jpg",
                "https://upload.wikimedia.org/wikipedia/en/thumb/3/3b/Chipotle_Mexican_Grill_logo.svg/1200px-Chipotle_Mexican_Grill_logo.svg.png",
                "https://hackthemenu.com/wp-content/uploads/2013/11/panera-bread-logo.jpg",
                "https://m.media-amazon.com/images/I/51lGuDbUm8L.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRB5P6SDKIwYbe6OVAkUUYuZD5WEvDJ3waArw&usqp=CAU",
                "https://logowik.com/content/uploads/images/770_chilis.jpg"
        };

        sliderItems.add(new SliderItem("https://as1.ftcdn.net/v2/jpg/05/52/50/18/1000_F_552501822_fLn9vSom1JC7rbxXTECpn9GpAywWQG2f.jpg",
                12.500, 30, 50, false, true, true, imageUrls));
        sliderItems.add(new SliderItem("https://as1.ftcdn.net/v2/jpg/05/51/33/08/1000_F_551330828_00iVevc8gmRn6N3wAhQ1WDgD4jraTPMX.jpg",
                20.750, 15, 25, true, false, false, imageUrls));
        sliderItems.add(new SliderItem("https://wallpapers.com/images/hd/beautiful-scenery-pictures-a1i59josvdrfxg9m.jpg",
                8.990, 45, 75, false, true, false, imageUrls));
        sliderItems.add(new SliderItem("https://c4.wallpaperflare.com/wallpaper/297/22/531/lake-blue-moonlight-moon-wallpaper-preview.jpg",
                5.250, 60, 100, true, true, true, imageUrls));
    }
}