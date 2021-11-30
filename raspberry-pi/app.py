import time
import board
import adafruit_dht
import psutil
import RPi.GPIO as GPIO

import requests
import http.client

if __name__ == '__main__':
    # Inisialisasi variable
    list_state = []
    temperature = 0
    humidity = 0
    # base_url = "http://emon.fajarlabs.com/"
    host_url = "emon.fajarlabs.com"
    GPIO.setmode(GPIO.BCM)     # set up BCM GPIO numbering

    # daftar INPUT PIN dimasukkan kedalam list
    list_io = [17, 22, 27] # index 0=R, 1=S, 2=T

    # We first check if a libgpiod process is running. If yes, we kill it!
    for proc in psutil.process_iter():
        if proc.name() == 'libgpiod_pulsein' or proc.name() == 'libgpiod_pulsei':
            proc.kill()

    # Inisialisasi GPIO menjadi INPUT
    for _gpio in list_io :
        GPIO.setup(_gpio, GPIO.IN)

    # Sensor DHT11 menggunakan pin D4
    sensor = adafruit_dht.DHT11(board.D4)

    # tunggu 1 detik, untuk memberi waktu inisialisasi input sensor
    time.sleep(1)

    while(1):
        try:
            # baca sensor suhu (temperature)
            temperature = sensor.temperature
            # baca sensor kelembapan udara (humidity)
            humidity = sensor.humidity
        except Exception as e:
            print(e)

        try:
            # baca semua data input sensor R S T
            for __gpio in list_io :
                is_state = False
                if GPIO.input(__gpio):
                    is_state = True
                list_state.append(is_state)
                print("State GPIO : {} : {} ".format(__gpio, is_state))
        except Exception as e :
            print(e)

        print("Temperature: {}*C   Humidity: {}% ".format(temperature, humidity))

        # check data R_S_T apakah lengkap atau ada 3 item
        if len(list_state)  == 3 :
            # kirim ke server
            url = "/?act=add&r={}&s={}&t={}&temperature={}&humidity={}".format(int(list_state[0]), int(list_state[1]), int(list_state[2]), temperature, humidity)
            print(url)
            try :
                conn = http.client.HTTPSConnection(host_url)
                payload = ''
                headers = {}
                conn.request("GET", url, payload, headers)
                res = conn.getresponse()
                data = res.read()
                print(data.decode("utf-8"))
            except Exception as e :
                print(e)

        list_state = [] # reset list_state
        time.sleep(1)