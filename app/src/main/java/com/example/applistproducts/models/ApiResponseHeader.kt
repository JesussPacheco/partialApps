package com.example.applistproducts.models

import com.google.gson.annotations.SerializedName

class ApiResponseHeader (
    @SerializedName("api")
    var api: ApiResponseDetails
)