package com.indiabana.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.indiabana.Adapters.HomeScreenRecommendedRVAdapter;
import com.indiabana.Adapters.QuestionRVAdapter;
import com.indiabana.Adapters.ReviewImageRVAdapter;
import com.indiabana.Adapters.ReviewRVAdapter;
import com.indiabana.Data.QuestionRVItem;
import com.indiabana.Data.RecommendedRVItem;
import com.indiabana.Data.ReviewImageRVItem;
import com.indiabana.Data.ReviewRVItem;
import com.indiabana.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    CarouselView carouselView;
    ImageButton backBtn;
    int[] sampleImages = {R.drawable.img1, R.drawable.img2, R.drawable.img3};

    RecyclerView questions_rv,reviews_rv,images_rv,recommended_rv;

    ArrayList<QuestionRVItem> qsList=new ArrayList<>();
    ArrayList<ReviewRVItem> reviewList =new ArrayList<>();
    ArrayList<ReviewImageRVItem> imageList=new ArrayList<>();
    ArrayList<RecommendedRVItem> recommendedList=new ArrayList<>();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_item);
        carouselView = (CarouselView) findViewById(R.id.carouselView);
        questions_rv=findViewById(R.id.previous_question_rv);
        reviews_rv=findViewById(R.id.customer_reviews_rv);
        images_rv=findViewById(R.id.product_images_by_reviewer_rv);
        recommended_rv=findViewById(R.id.recommended_items_rv);
        backBtn=findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        qsList.add(new QuestionRVItem("","","",""));
        qsList.add(new QuestionRVItem("","","",""));
        qsList.add(new QuestionRVItem("","","",""));

        reviewList.add(new ReviewRVItem("","","","",1,2,2));
        reviewList.add(new ReviewRVItem("","","","",1,2,2));
        reviewList.add(new ReviewRVItem("","","","",1,2,2));

        imageList.add(new ReviewImageRVItem("",""));
        imageList.add(new ReviewImageRVItem("",""));
        imageList.add(new ReviewImageRVItem("",""));
        imageList.add(new ReviewImageRVItem("",""));
        imageList.add(new ReviewImageRVItem("",""));

        recommendedList.add(new RecommendedRVItem("","","","",""));
        recommendedList.add(new RecommendedRVItem("","","","",""));
        recommendedList.add(new RecommendedRVItem("","","","",""));
        recommendedList.add(new RecommendedRVItem("","","","",""));
        recommendedList.add(new RecommendedRVItem("","","","",""));

        QuestionRVAdapter questionRVAdapter = new QuestionRVAdapter(qsList);
        questions_rv.setAdapter(questionRVAdapter);

        ReviewRVAdapter reviewRVAdapter = new ReviewRVAdapter(reviewList);
        reviews_rv.setAdapter(reviewRVAdapter);

        ReviewImageRVAdapter reviewImageRVAdapter = new ReviewImageRVAdapter(imageList);
        images_rv.setAdapter(reviewImageRVAdapter);


        HomeScreenRecommendedRVAdapter adapter= new HomeScreenRecommendedRVAdapter(recommendedList);
        recommended_rv.setAdapter(adapter);


        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

}
