# DataStoreEx
Many thanks to the raywenderlich.com website for tutorial on JetPack DataStore. \
This is an exercise of the new feature.

JetPack DataStore support storage of 2 types.

- Preference: Key value pair (upgrade of existing sharedPreference)
- Proto: Custom schema

<img width="200" src="https://user-images.githubusercontent.com/1282659/112736203-dd541c80-8f1e-11eb-9963-8a59b12cfd37.png">

### Preference

Exercise Boolean and String storage.  Right (read-only) value is a returned from DataStore. \
(a) app startup retrival   (b) update data   (c) refresh page - data retrival \
<img width="200" src="https://user-images.githubusercontent.com/1282659/108612490-e34e5f00-73ae-11eb-86d8-a392cd7888a7.png"> <img width="200" src="https://user-images.githubusercontent.com/1282659/108612491-e3e6f580-73ae-11eb-9ffd-bd9524caca7c.png"> <img width="200" src="https://user-images.githubusercontent.com/1282659/108612492-e3e6f580-73ae-11eb-9ab3-ce6c3273959c.png">

### Proto

Exercise define a custom type of Developer which is composed of 'Name' (String), 'Id' (Int), and 'Is_Remote' (Boolean).
```
syntax = "proto3";

option java_package = "com.ctyeung.datastoreex";
option java_multiple_files = true;

message Developer {
  string name = 1;
  int32 id = 2;
  bool is_remote = 3;
}
```

(a) entry/update DataStore  (b) read from DataStore (right column) \
<img width="200" src="https://user-images.githubusercontent.com/1282659/108633381-9499d700-7439-11eb-98bb-d38c604820c0.png"> <img width="200" src="https://user-images.githubusercontent.com/1282659/108633383-95cb0400-7439-11eb-9b6b-0c5004ca734c.png">

### Proto - List
variable length List<Int> is accomplished with a 'repeated' attribute.
```
message DataItem {
  repeated int32 num = 1;
}
```
<img width="200" src="https://user-images.githubusercontent.com/1282659/109855634-282f8c80-7c1e-11eb-9b49-f124fab84155.png">

### Proto - Map (Hash table)
variable length map<key, value> is supported for basic key-value types
```
message Record {
  map <string, string> hash = 1;
}
```
<img width="200" src="https://user-images.githubusercontent.com/1282659/112736202-dcbb8600-8f1e-11eb-8044-526aefd3e81c.png">

# Android Studio 4.1 Release

# Device
Samsung S9 Galaxy phone.

# References

1. DataStore Tutorial For Android: Getting Started by Luka Kordić, December 21, 2020 \
https://www.raywenderlich.com/18348259-datastore-tutorial-for-android-getting-started

2. Google developers documentation \
https://developer.android.com/topic/libraries/architecture/datastore?gclid=CjwKCAiAg8OBBhA8EiwAlKw3krYbuBUsn2oONORxG0eUR46XKptzVTR1b3mEuc1EKO1OKCnZdKG-thoCEJEQAvD_BwE&gclsrc=aw.ds 

3. Working with Proto DataStore, Code lab \
https://developer.android.com/codelabs/android-proto-datastore \
https://github.com/googlecodelabs/android-datastore/tree/proto_datastore
