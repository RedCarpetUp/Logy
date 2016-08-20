[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Logy-green.svg?style=true)](https://android-arsenal.com/details/1/4177)



<img align="center" src='https://github.com/balrampandey19/Logy/blob/master/logy.jpg' width='400' height='200'/>



#A Simple clean, and powerful Android logger.

##By using logy you can get

* Clean output 
* Clean JSON output.
* Remove all logs atomatically on Release Build.
* Thread Imformation
* Easy to implement
* Lightweight and clean library
* Jump to source

#Usage

####Simple logs with logy

```
  Logy.e("Logy Error", "error");
  
  Logy.d("Logy Debug", "Debug");
  
  Logy.v("Logy VERBOSE", "VERBOSE");
  
  Logy.i("Logy INFO", "INFO");
  
  Logy.w("Logu WARN", "WARN");
  
  ```
####JSON with logy

```
String json="{\"phonetype\":\"N95\",\"cat\":\"WP\"}\n";
        try {
        JSONObject jsonObj = new JSONObject(json);
     Logy.json("Logy JSON",jsonObj);
        } catch (JSONException e) {
            e.printStackTrace();
        }

```
####Disable logy in debug build
```
Logy.setEnable(false);

```
####Array, ArrayList with logy

```
Logy.d(list);
```

#Download
###Repository

The Gradle dependency is available via jCenter. jCenter is the default Maven repository used by Android Studio.
```
dependencies {

compile 'co.balrampandey:logy:1.0.0'

}
```

#License

```

Copyright 2016 Balram Pandey

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```



