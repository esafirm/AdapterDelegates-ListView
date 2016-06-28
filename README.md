[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-AdapterDelegates--ListView-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/3784)

## AdapterDelegates-ListView

Based on https://github.com/sockeqwe/AdapterDelegates." Favor composition over inheritance" for ListView

## Features

- Composable view handling on ListView
- Plugable data handler
- ViewHolder pattern for free

## Dependencies


```groovy
allprojects {
	repositories {
		maven { url "https://jitpack.io" }
	}
}

dependencies {
	compile 'com.github.esafirm:AdapterDelegates-ListView:v1.0.0'
}
```

## Basic Usage

#### Adapter

For minimum boilerplate use `BaseListDelegatesAdapter`

```java
public class AnimalAdapter extends BaseListDelegatesAdapter<Animal> {
  public AnimalAdapter(Context context) {
    super(context);
    addDelegate(new BirdDelegate(mContext, 0));
    addDelegate(new RabbitDelegate(mContext, 1));
  }
}
```

#### AdapterDelegate

```java
public class RabbitDelegate extends AbsAdapterDelegate<Animal> {

  public RabbitDelegate(Context context, int viewType) {
    super(context, viewType);
  }

  @Override public boolean isForType(Animal animal, int position) {
    return animal instanceof Rabbit;
  }

  @Override public BaseViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {
    TextView textView = new TextView(mContext); //mContext is protected field
    return new BirdViewHolder(textView);
  }

  @Override public void onBindData(BaseViewHolder viewHolder, Animal animal, int position) {
    ((TextView) viewHolder.itemView).setText("Rabbit");
  }

  static class BirdViewHolder extends BaseViewHolder {

    public BirdViewHolder(View view) {
      super(view);
    }
  }
}
```


## License
```
The MIT License (MIT)

Copyright (c) 2016 Esa Firman

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
