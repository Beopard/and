package com.example.anonymousboard.model

data class Order(
    var ord_id: String,
    var user_id: String,
    var ord_amount: String,
    var keep_status: String,
    var entrust_time: String,
    var withdraw_time: String,
    var keep_start: String,
    var keep_end: String,
    var delivery_id: String,
    var call_time: String,
    var status: String,
    var pay_id: String,
    var ord_selection: String,
    var ord_request: String

)