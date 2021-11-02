<?php

// save data
// http://emon.fajarlabs.com/?act=add&r=0&s=0&t=0&temperature_1=0&temperature_2=0
// get data
// http://emon.fajarlabs.com/?act=get

$servername = "localhost";
$username = "fajarla1_emon";
$password = "emon12345&*";
$dbname = "fajarla1_emon";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
$data = new stdClass();

$act = isset($_GET["act"]) ? $_GET["act"] : "";
$r = isset($_GET["r"]) ? $_GET["r"] : "";
$s = isset($_GET["s"]) ? $_GET["s"] : "";
$t = isset($_GET["t"]) ? $_GET["t"] : "";
$temperature_1 = isset($_GET["temperature_1"]) ? $_GET["temperature_1"] : "";
$temperature_2 = isset($_GET["temperature_2"]) ? $_GET["temperature_2"] : "";

function add_raw($r, $s, $t, $temperature_1, $temperature_2, &$conn){
    $sql = "INSERT INTO src_raw_data (r, s, t, temperature_1, temperature_2)
    VALUES (?, ?, ?, ?, ?)";
    
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("iiiii", $r, $s, $t, $temperature_1, $temperature_2);
    
    $stmt->execute();
    $stmt->close();
}

function update_raw_api($r, $s, $t, $temperature_1, $temperature_2, &$conn){
    $sql = "UPDATE src_raw_data_api SET r = ?, s = ?, t = ?, temperature_1 = ?, temperature_2 = ? ";
    
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("iiiii", $r, $s, $t, $temperature_1, $temperature_2);
    
    $stmt->execute();
    $stmt->close();
}

function get_all(&$conn) {
    $result = [];

    if ($result = $conn->query("SELECT * FROM src_raw_data_api LIMIT 1")) {
        $result = $result->fetch_assoc();
    }
    
    return $result;
}

if($act == 'add'){
    update_raw_api($r, $s, $t, $temperature_1, $temperature_2, $conn);
    add_raw($r, $s, $t, $temperature_1, $temperature_2, $conn);
    $data->success = true;
    $data->response = "The request was successfully completed.";
    $data->code = 200;
} else if($act == 'get'){
    $data->success = true;
    $data->response = get_all($conn);
    $data->code = 200;
} else {
    $data->success = true;
    $data->response = "No action";
    $data->code = 200;
}

header('Content-Type: application/json; charset=utf-8');
echo json_encode($data);
?>