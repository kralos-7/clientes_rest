<?php

$data = json_decode( file_get_contents('http://127.0.0.1:8484/users'), true );
print_r($data[0]);
print_r($data);

