package com.esafirm.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import com.esafirm.adapterdelegateslistview.data.AbsAdapterDataHandler;
import com.esafirm.sample.model.Animal;
import com.esafirm.sample.model.Bird;
import com.esafirm.sample.model.Rabbit;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private ListView mListView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mListView = (ListView) findViewById(R.id.listview);

    initDefault();
  }

  private void initDefault() {
    AnimalAdapter adapter = new AnimalAdapter(this);
    mListView.setAdapter(adapter);
    adapter.setData(getAnimals());
  }

  private void initCustomDataHandler() {
    AnimalAdapter adapter = new AnimalAdapter(this);
    adapter.setDataHandler(new AbsAdapterDataHandler<Animal>(adapter) {

      @Override public Animal getItem(int position) {
        return position > 50 ? new Rabbit() : new Bird();
      }

      @Override public int getCount() {
        return 100;
      }

      @Override public void pushData(Iterable<Animal> data) {
        // no-op
      }
    });
    mListView.setAdapter(adapter);
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    menu.add(0, Menu.FIRST, 0, "Default");
    menu.add(0, Menu.FIRST + 1, 0, "Custom Data Handler");
    return super.onCreateOptionsMenu(menu);
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case Menu.FIRST:
        initDefault();
        break;
      default:
        initCustomDataHandler();
    }
    return super.onOptionsItemSelected(item);
  }

  private static List<Animal> getAnimals() {
    List<Animal> animals = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      animals.add(i % 2 == 0 ? new Rabbit() : new Bird());
    }
    return animals;
  }
}
