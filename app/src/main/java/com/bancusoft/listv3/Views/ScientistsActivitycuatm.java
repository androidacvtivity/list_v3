package com.bancusoft.listv3.Views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ProgressBar;
import android.widget.SearchView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import com.bancusoft.listv3.Helpers.MyAdaptercuatm;
import com.bancusoft.listv3.Helpers.Utils;
import com.bancusoft.listv3.R;

import com.bancusoft.listv3.Retrofit.ResponseModelcuatm;
import com.bancusoft.listv3.Retrofit.RestApi;
import com.bancusoft.listv3.Retrofit.Cl_cuatm_all;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class ScientistsActivitycuatm extends AppCompatActivity
        implements SearchView.OnQueryTextListener,MenuItem.OnActionExpandListener{

    //We define our instance fields
    private RecyclerView rv;
    private MyAdaptercuatm mAdapter;
    private LinearLayoutManager layoutManager;
    public ArrayList<Cl_cuatm_all> allPagesScientists = new ArrayList<>();
    private List<Cl_cuatm_all> currentPageScientists;
    private Boolean isScrolling = false;
    private int currentScientists, totalScientists, scrolledOutScientists;
    private ProgressBar mProgressBar;

    /**
     * We initialize our widgets
     */
    private void initializeViews() {
        mProgressBar = findViewById(R.id.mProgressBarLoadcuatm);
        mProgressBar.setIndeterminate(true);
        Utils.showProgressBar(mProgressBar);
        rv = findViewById(R.id.mRecyclerViewcuatm);
    }

    /**
     * This method will setup oir RecyclerView
     */
    private void setupRecyclerView() {
        layoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdaptercuatm(this, allPagesScientists);
        rv.setAdapter(mAdapter);
        rv.setLayoutManager(layoutManager);
        rv.setBackgroundColor(Color.TRANSPARENT);
    }
    /**
     * This method will download for us data from php mysql based on supplied query string
     * as well as pagination parameters. We are basiclally searching or selecting data
     * without seaching. However all the arriving data is paginated at the server level.
     */
    private void retrieveAndFillRecyclerView(final String action, String queryString,
                                             final String start) {

        mAdapter.searchString = queryString;
        RestApi api = Utils.getClient().create(RestApi.class);
        Call<ResponseModelcuatm> retrievedData;

        if (action.equalsIgnoreCase("GET_PAGINATEDCUATM")) {
            retrievedData = api.search_cl_cuatm_all("GET_PAGINATEDCUATM", queryString, start, "100");
            Utils.showProgressBar(mProgressBar);
        } else if (action.equalsIgnoreCase("GET_PAGINATED_SEARCHCUATM")) {
            Utils.showProgressBar(mProgressBar);
            retrievedData = api.search_cl_cuatm_all("GET_PAGINATED_SEARCHCUATM", queryString, start, "100");
        } else {
            Utils.showProgressBar(mProgressBar);
            retrievedData = api.retrievecuatm();
        }


        retrievedData.enqueue(new Callback<>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<ResponseModelcuatm> call, @NonNull Response<ResponseModelcuatm>
                    response) {
                assert response.body() != null;
                Log.d("RETROFIT", "CODE : " + response.body().getCodecu());
                Log.d("RETROFIT", "MESSAGE : " + response.body().getMessagecu());
                Log.d("RETROFIT", "RESPONSE : " + response.body().getResultcuatm());
                currentPageScientists = response.body().getResultcuatm();

                if (currentPageScientists != null && !currentPageScientists.isEmpty()) {
                    if (action.equalsIgnoreCase("GET_PAGINATED_SEARCHCUATM")) {
                        allPagesScientists.clear();
                    }
                    allPagesScientists.addAll(currentPageScientists);

                } else {
                    if (action.equalsIgnoreCase("GET_PAGINATED_SEARCHCUATM")) {
                        allPagesScientists.clear();
                    }
                }
                mAdapter.notifyDataSetChanged();
                Utils.hideProgressBar(mProgressBar);
            }

            @Override
            public void onFailure(@NonNull Call<ResponseModelcuatm> call, @NonNull Throwable t) {
                Utils.hideProgressBar(mProgressBar);
                Log.d("RETROFIT", "ERROR: " + t.getMessage());
                Utils.showInfoDialog(ScientistsActivitycuatm.this, "ERROR", t.getMessage());
            }
        });
    }
    /**
     * We will listen to scroll events. This is important as we are implementing scroll to
     * load more data pagination technique
     */
    private void listenToRecyclerViewScroll() {
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView rv, int newState) {
                //when scrolling starts
                super.onScrollStateChanged(rv, newState);
                //check for scroll state
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true;
                }
            }
            @Override
            public void onScrolled(@NonNull RecyclerView rv, int dx, int dy) {
                // When the scrolling has stopped
                super.onScrolled(rv, dx, dy);
                currentScientists = layoutManager.getChildCount();
                totalScientists = layoutManager.getItemCount();
                scrolledOutScientists = ((LinearLayoutManager) Objects.requireNonNull(rv.getLayoutManager())).
                        findFirstVisibleItemPosition();

                if (isScrolling && (currentScientists + scrolledOutScientists ==
                        totalScientists)) {
                    isScrolling = false;

                    if (dy > 0) {
                        // Scrolling up
                        retrieveAndFillRecyclerView("GET_PAGINATEDCUATM",
                                mAdapter.searchString,
                                String.valueOf(totalScientists));

                    } else {
                        // Scrolling down
                    }
                }
            }
        });
    }
    /**
     * We inflate our menu. We show SearchView inside the toolbar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.scientists_page_menu_cuatm, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search_cuatm);
        SearchView searchView = (SearchView) searchItem.getActionView();
        assert searchView != null;
        searchView.setOnQueryTextListener(this);
        searchView.setIconified(true);
        searchView.setQueryHint("Căutare");
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        if (id==R.id.action_new_cuatm){
            Utils.openActivity(this, help_vw.class);
            finish();
            return true;

        } else

        if (id==R.id.action_new_en_cuatm){
            Utils.openActivity(this, help_vw_en.class);
            finish();
            return true;

        } else

        if (id==R.id.action_new_ru_cuatm){
            Utils.openActivity(this, help_vw_ru.class);
            finish();
            return true;

        } else

        if (id == android.R.id.home){

            Intent intent;
            intent = new Intent(this,DashboardActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(intent);
            return true;

        }

        else
        if (id == R.id.video2_cuatm) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(com.bancusoft.listv3.Helpers.Utils.youtube_level_stat));

            startActivity(browserIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        retrieveAndFillRecyclerView("GET_PAGINATED_SEARCHCUATM", query, "0");
        return false;
    }

    @Override
    public boolean onMenuItemActionExpand(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public boolean onMenuItemActionCollapse(@NonNull MenuItem item) {
        return false;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cl_cuatm_all);
        //-----------------------------

        // Register the onBackPressed callback
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                Intent intent = new Intent(ScientistsActivitycuatm.this, DashboardActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
                startActivity(intent);
            }
        };

        // Add the callback to the dispatcher
        getOnBackPressedDispatcher().addCallback(this, callback);

//-----------------------------
        initializeViews();
        this.listenToRecyclerViewScroll();
        setupRecyclerView();
        retrieveAndFillRecyclerView("GET_PAGINATEDCUATM", "", "0");
    }
}
