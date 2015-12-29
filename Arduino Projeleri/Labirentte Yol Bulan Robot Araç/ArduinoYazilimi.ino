// BİSMİLLAHİRRAHMANİRRAHİM

#define dir1PinA 2
#define dir2PinA 3
#define dir1PinB 4
#define dir2PinB 5

#define speedPinA 6
#define speedPinB 7

#define ontrigPin 8 
#define onechoPin 9

#define sagtrigPin 10 
#define sagechoPin 11

#define soltrigPin 12
#define solechoPin 13 

#include <Arduino.h>

int minimumMesafe = 6; 
double microsaniyeSure, onMesafe, sagMesafe, solMesafe = 0;



void ileri(int hiz)
{
   analogWrite(speedPinA, hiz);
   analogWrite(speedPinB, hiz);
   
   digitalWrite(dir1PinA, HIGH);
   digitalWrite(dir2PinA, LOW);
   
   
   digitalWrite(dir1PinB, HIGH);
   digitalWrite(dir2PinB, LOW);
}

void geri(int hiz, int sure)
{
   analogWrite(speedPinA, hiz);
   digitalWrite(dir1PinA, LOW);
   digitalWrite(dir2PinA, HIGH);
   
   analogWrite(speedPinB, hiz);
   digitalWrite(dir1PinB, LOW);
   digitalWrite(dir2PinB, HIGH);
   
   delay(sure);
}

void sagadon(int hiz, int sure)
{
  analogWrite(speedPinA, hiz);
   digitalWrite(dir1PinA, LOW);
   digitalWrite(dir2PinA, HIGH);
   
   analogWrite(speedPinB, hiz);
   digitalWrite(dir1PinB, HIGH);
   digitalWrite(dir2PinB, LOW);
   delay(sure);
}

void soladon(int hiz, int sure)
{
  analogWrite(speedPinB, hiz);
   digitalWrite(dir1PinB, LOW);
   digitalWrite(dir2PinB, HIGH);
   
   analogWrite(speedPinA, hiz);
   digitalWrite(dir1PinA, HIGH);
   digitalWrite(dir2PinA, LOW);
   delay(sure);
}

void dur(int sure)
{
   digitalWrite(dir1PinB, LOW);
   digitalWrite(dir2PinB, LOW);
   
   digitalWrite(dir1PinA, LOW);
   digitalWrite(dir2PinA, LOW);
   delay(sure);
}

void mesafeolcum(double& sensor, int trig, int echo)
{
  double mesafe, sonmesafe;
  digitalWrite(trig, LOW); 
  delayMicroseconds(2); 

  digitalWrite(trig, HIGH);
  delayMicroseconds(10); 
 
  digitalWrite(trig, LOW); 
  microsaniyeSure = pulseIn(echo, HIGH); 

  mesafe = microsaniyeSure/70; 
  
  while(true)
  {
  digitalWrite(trig, LOW); 
  delayMicroseconds(2); 

  digitalWrite(trig, HIGH);
  delayMicroseconds(10); 
 
  digitalWrite(trig, LOW); 
  microsaniyeSure = pulseIn(echo, HIGH); 
  sonmesafe = microsaniyeSure/70;
  if( abs(mesafe - sonmesafe) < 1  ) {sensor = sonmesafe; return;} 
  mesafe = sonmesafe;
  
  }
}


void solmesafe()
{
  mesafeolcum(solMesafe, soltrigPin, solechoPin);
}

void sagmesafe()
{
  mesafeolcum(sagMesafe, sagtrigPin, sagechoPin);
}

void onmesafe()
{
  mesafeolcum(onMesafe, ontrigPin, onechoPin);
}
void restart()
{
   asm volatile ("  jmp 0");
}
void setup() {  

// Serial.begin(9600);
 pinMode(ontrigPin, OUTPUT); 
 pinMode(onechoPin, INPUT);  
 
 pinMode(sagtrigPin, OUTPUT); 
 pinMode(sagechoPin, INPUT); 
 
 pinMode(soltrigPin, OUTPUT);
 pinMode(solechoPin, INPUT);  

 pinMode(dir1PinA,OUTPUT);
 pinMode(dir2PinA,OUTPUT);
 pinMode(speedPinA,OUTPUT);
 pinMode(dir1PinB,OUTPUT);
 pinMode(dir2PinB,OUTPUT);
 pinMode(speedPinB,OUTPUT);
 
 delay(2000);

}



void loop() 
{

  while(true)
  {
  
    onmesafe();
    if(onMesafe > 200) continue;
    if(onMesafe > 4) { ileri(255); continue; }
    
    sagmesafe();
    if(sagMesafe > 200) continue;
    if(sagMesafe > 6) { dur(50); sagadon(255, 400); continue; }
    
    solmesafe();
    if(solMesafe > 200) continue;
    if(solMesafe > 6) { dur(50); soladon(255, 400); continue; }
    
    geri(255,0);
    
  
  }
  
 }
 
