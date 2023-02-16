# Horizontal-Calendar

# Screen Shot
![This is an image](https://s4.aconvert.com/convert/p3r68-cdx67/ayic2-yb8ka.jpg)
![This is an image](https://s4.aconvert.com/convert/p3r68-cdx67/a3agx-3tnyn.jpg)
![This is an image](https://s4.aconvert.com/convert/p3r68-cdx67/aicii-57905.jpg)

### How to Use

Step 1. Add it in your root build.gradle at the end of repositories:
```allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```
```
Step 2. Add the dependency
dependencies {
	        implementation 'com.github.TecOrb-Developers:Horizontal-Calendar:v1.0.0'
	}
```


Step 3 .Create array list  to save dates

~~~
   var  resultBeanList:ArrayList() = DateFormatter.horizontalCalender(30)

  ~~~

  Step 4 . get the reference of RecyclerView

  ```
   val manager: RecyclerView.LayoutManager =
              LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
  ```

   Step 5.call the constructor of CustomAdapter to send the reference and data to Adapter

    ```
    val adapterDate = AdapterDate(this, resultBeanList, this)
            binding.recyclerView.adapter = adapterDate
            binding.recyclerView.layoutManager = manager
    ```
