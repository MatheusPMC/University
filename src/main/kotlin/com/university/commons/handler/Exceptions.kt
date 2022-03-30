package com.exampleInte.commons.handler

import java.lang.RuntimeException

class MongoException(msg: String) : RuntimeException(msg)

class AwsConnectionException(msg: String) : RuntimeException(msg)