# json2intent

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-json2intent-green.svg?style=flat)](https://android-arsenal.com/details/1/2136)
[![Download](https://api.bintray.com/packages/8tory/maven/json2intent/images/download.svg) ](https://bintray.com/8tory/maven/json2intent/_latestVersion)
[![JitPack](https://img.shields.io/github/tag/8tory/json2intent.svg?label=JitPack)](https://jitpack.io/#8tory/json2intent)
[![javadoc](https://img.shields.io/github/tag/8tory/json2intent.svg?label=javadoc)](https://jitpack.io/com/github/8tory/json2intent/f0c95a6cf4/javadoc/index.html)
[![Build Status](https://travis-ci.org/8tory/json2intent.svg)](https://travis-ci.org/8tory/json2intent)
[![Join the chat at https://gitter.im/8tory/json2intent](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/8tory/json2intent?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Convert JSON to Android Intent.

## Usage

```java
Json2Intent.from(context).with(json).startActivity();
```

```java
Json2Intent.from(context).with(json).startService();
```

## Installation

via jitpack:

```gradle
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.8tory:json2intent:-SNAPSHOT'
}
```

via jcenter:

```gradle
repositories {
    jcenter()
}

dependencies {
    compile 'com.infstory:json2intent:1.0.0'
}
```

## Input json format

```json
{
    "intent": {
        "action": "android.intent.action.VIEW",
        "uri": "https://play.google.com/store/apps/details?id=com.story8.android.gallery"
    }
}
```

## Live Demo

in progress.

## LICENSE

```
Copyright 2015 8tory, Inc.

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
