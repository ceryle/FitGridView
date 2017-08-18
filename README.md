[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-FitGridView-green.svg?style=true)](https://android-arsenal.com/details/1/4927) [![](https://jitpack.io/v/ceryle/fitgridview.svg)](https://jitpack.io/#ceryle/fitgridview)

# FitGridView

![poster](https://cloud.githubusercontent.com/assets/20969019/21449819/b230b9a4-c8f9-11e6-8620-7a2297f96d71.png)<br />In this library, GridView is extended with a few methods to achieve fitting it to a given size.

## Preview
![preview](https://cloud.githubusercontent.com/assets/20969019/21449604/9b90ceac-c8f7-11e6-9c32-3c94b24f8e15.gif)


## Installation

#### Gradle

Add it to your build.gradle with:
```gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```
and:

```gradle
dependencies {
    compile 'com.github.ceryle:FitGridView:v1.0.5'
}
```

## Customization

### Some Attributes

#### Segmented Button
| Option Name      				| Format                 | Description                              |
| ---------------- 				| ---------------------- | -----------------------------            |
| app:row         | `integer`               |  number of rows    |
| app:column       | `integer`               | number of colums |



#### Examples

##### In Xml Layout
```xml
<co.ceryle.fitgridview.FitGridView
     android:id="@+id/gridView"
     android:layout_width="match_parent"
     android:layout_height="match_parent"
     android:listSelector="@android:color/transparent"
     app:column="3"
     app:row="4"/>
```

##### In Java
###### in your main activity:
```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    gridView = (FitGridView) findViewById(R.id.gridView);
    gridView.setFitGridAdapter(new Adapter(this));
        
    // you can change grid view size any time. don't forget calling update method.
    changeSize(4, 4);
}
        
private void changeSize(int r, int c) {
     gridView.setRow(r);
     gridView.setColumn(c);
     gridView.update();
}
```

###### in your adapter:
```java
// In adapter, you can define your grid size by passing it to super method.
int dataSize = 15;
Adapter(Context context) {
        super(context, R.layout.grid_item, dataSize);
        this.context = context;
}
```

## License

This project is licensed under the Apache License Version 2.0 - see the [LICENSE.md](LICENSE.md) file for details
