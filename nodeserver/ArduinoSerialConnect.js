const SerialPort = require('serialport');
const express = require('express');
const http = require('http');
const socketIo = require("socket.io");

var serialPort;
var Readline = SerialPort.parsers.Readline
var parser = new Readline();
const port = 4001;
const app = express();
// server instance
const server = http.createServer(app)
// socketio 생성후 서버 인스턴스 사용
const io = socketIo(server, {
    cors: {
    origin: '*',
    }
});
try {
    serialPort = new SerialPort("COM14",{
        baudRate: 9600,
        dataBits: 8,
        parity: 'none',
        stopBits: 1,
        flowControl: false

    });
    serialPort.pipe(parser)
    // serialPort.on('open', function () {
    //     console.log("시리얼포트 오픈");
    // })
    // parser.on('open', function () {
    //     console.log("시리얼포트 오픈");
    // })
    // parser.on('error',function(err){
    //     console.log("err", err)
    // })
    // parser.on('data',function(data){
    //     console.log(data)
    // })
     io.on("connection", (socket) => {
        socket.on('serialEvent',function(data){
            //시리얼 통신
            parser.on('data',function(data){
                socket.emit('result',data)
            })
            
        })
        socket.on('disconnect',()=>{
            console.log("연결 해제")
        })
    })


} catch (error) {
    console.log(error)
}
server.listen(port, () => console.log(`Listening on port ${port}`))

