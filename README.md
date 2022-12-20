# Nagne
## 경북대학교 모바일 앱 프로그래밍1 Team project
### 팀원
* 2018112111 서정엽
* 2020112099 송민지
* 2020114702 이예림
* 2020111674 이지안


### 어플리케이션 제작 - "Nagne"
#### 여행 일지를 이미지나 텍스트로 기록하고 여행 장소를 추천 받을 수 있는 어플리케이션을 제작하고자 함

<br>
<div align="center">

<div>
<img width="220" src="https://user-images.githubusercontent.com/110325367/208614458-b7fe496b-8948-4dc5-9d59-f7a2216ca146.png"/>           <img width="220" src="https://user-images.githubusercontent.com/110325367/208614722-c3f42828-589c-4b99-b4bd-be70ce60aee8.png"/>
    </div>

<br><br>
<div align="center">
    
   Yolov5🚀의 취약점 검사를 위해 COCO val 2017의 동물 객체 중 8가지를 카테고리로, 툴은 DALL-E-2를 이용해 생성한 이미지를 데이터 셋으로 하여 정확도를 검사한다.
   도출된 취약점 개선을 위해 디노이징🚀(NAFNET), SR🚀(HAT)로 최적화 후 정확도 검사 연구를 진행한다.
  
</div>
<br>
    
# Tool
                       [<img src="https://img.shields.io/badge/Python-3766AB?style=flat-square&logo=Python&logoColor=white"/>](https://www.python.org/)
  [<img src="https://img.shields.io/badge/OpenAI-412991?style=flat-square&logo=Python&logoColor=white"/>](https://openai.com/dall-e-2/)
  [<img src="https://img.shields.io/badge/Google Colab-F9AB00?style=flat-square&logo=Python&logoColor=white"/></a>](https://colab.research.google.com/drive/1gjUVQBpd7Ib5NlojBwcZRh3B2MkRicc7#scrollTo=q2T8J68g11da)
  [<img src="https://img.shields.io/badge/Figma-F24E1E?style=flat-square&logo=Python&logoColor=white"/></a>](https://www.figma.com/file/XDfuWXEdcqPD4pNmuAuZx0/HI%3AM?node-id=25%3A548&t=SAizXbg7iZ7TVM0U-0)
  [<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=Python&logoColor=white"/></a>](https://developer.mozilla.org/ko/docs/Web/JavaScript)

<br>

## technology
<br>

> **Dalle-2**
> <br>[<img src="https://img.shields.io/badge/OpenAI-412991?style=flat-square&logo=Python&logoColor=white"/>](https://openai.com/dall-e-2/)

적대적 공격 사례에 활용되는 이미지들은 현실에 존재하는 이미지를 생성한 것이다. 그러므로 DALL-E-2를 활용하여 이미지를 생성할 때 작화 형식이 아닌 실제 현실과 유사한 사진 형식으로 이미지를 생성하기 위해 'A photo of'구문을 문장의 앞에 삽입하였다.
<br>

|한글|영어로 번역|DALL-E-2로 생성한 이미지|
|------|---|---|
|"냉장고를 열고 <br>샌드위치를 꺼내는 소"|"a photo of a cow that opens the <br>refrigerator and takes out a sandwich"|<img src = "https://user-images.githubusercontent.com/94797349/203352353-0eea3a28-0bfc-413b-89bb-a11486a88128.png" width="250" height="200"/>|

COCO val 2017의 동물 객체 중 8가지를 카테고리를 주요 객체로 문장들을 생성하였다.

|giraffe|bear|elephant|sheep|
|---|---|------|---|
|A photo of a giraffe that throws a discus in a truck|A photo of a bear sitting on a chair and eating a sandwich|A photo of a Elephant looking at the clock while putting flowers in the pot|A photo of a sheep truckload of apples and oranges with a salad and wine|
|<img src = "https://user-images.githubusercontent.com/94797349/203360905-13407716-f8ed-41a1-83bf-0474dc834214.png" width="150" height="150"/>|<img src = "https://user-images.githubusercontent.com/94797349/203361010-a807b5c8-4bac-45c6-8590-4ced594eb644.png" width="150" height="150"/>|<img src = "https://user-images.githubusercontent.com/94797349/203361123-f411c47e-a6c0-4901-9d89-be51a41e8cc4.png" width="150" height="150"/>|<img src = "https://user-images.githubusercontent.com/94797349/203361198-d7638f1b-2cbe-4b88-b230-7fd2391c7c5f.png" width="150" height="150"/>|
|cow|horse|dog|cat|
|A photo of a cow that opens the refrigerator and takes out a sandwich|A photo of a horse wearing sunglasses and lying on a sunbed under a pararol|A photo of a dog tried on shoes at a shoe store|A photo of a cat putting on lipstick in front of the mirror|
|<img src = "https://user-images.githubusercontent.com/94797349/203352353-0eea3a28-0bfc-413b-89bb-a11486a88128.png" width="150" height="150"/>|<img src = "https://user-images.githubusercontent.com/94797349/203361292-128292fe-9502-4558-a7ea-9f5b26bc1351.png" width="150" height="150"/>|<img src = "https://user-images.githubusercontent.com/94797349/203361371-7fbb1ea3-31c8-4cd4-9b44-12c73d85660c.png" width="150" height="150"/>|<img src = "https://user-images.githubusercontent.com/94797349/203361443-59c4029b-36c1-4903-9f55-4b497ecef3a9.png" width="150" height="150"/>|

<br>

> **Yolov5x**
> <br>: [YOLOv5](https://github.com/ultralytics/yolov5)

DALL-E-2에서 생성한 이미지를 YOLOv5의 pretrained 모델 중 가장 성능이 좋다고 평가된 YOLOv5x 모델에 넣어 정확도를 평가
<br><br>**YOLOv5 프레임워크:**<br>
<img src="https://user-images.githubusercontent.com/94797349/205436140-42c89d27-ae63-4b63-91ae-cbc71b1c273d.png" width="600" height="200"/>
<br>
|<img src = "https://user-images.githubusercontent.com/94797349/203380581-4a9f2a73-c6fb-4612-a84b-386517da3181.png" width="250" height="250"/>|<img src = "https://user-images.githubusercontent.com/94797349/203380664-2dc2a0cc-1b14-4ad5-872e-cdc10a8c3268.jpg" width="250" height="250"/>|
|--|--|
|데이터 이미지|YOLOv5x로 돌린 후(바운딩 박스 생성)|

<br>

> **디노이징**
> <br>: [NAFNET](https://github.com/megvii-research/NAFNet)

디노이징 툴인 NAFNET으로 데이터 이미지셋을 디노이징한 후, YOLOv5x로 다시 객체 인식해서 정확도 검사
<br><br>**NAFNET 프레임워크:**<br>
<img src="https://user-images.githubusercontent.com/94797349/205450910-f821d240-be41-4b8a-b130-664f6345faa5.jpg" width="400" height="150"/>
<img src="https://user-images.githubusercontent.com/94797349/205450934-e7e3b380-9192-4abc-b6c5-406feae56453.jpg" width="100" height="200"/>
<br>
|<img src = "https://user-images.githubusercontent.com/94797349/204239262-ed8409ac-fedf-4013-83d6-6648e7e88de3.png" width="250" height="250"/>|<img src = "https://user-images.githubusercontent.com/94797349/204239543-f334ae9f-35bf-4794-ac94-8593c78e6163.png" width="250" height="250"/>|
|--|--|
|데이터 이미지(Before denoising)|데이터 이미지(After denoising)|



<br>

> **SR**
> <br>: [HAT](https://github.com/XPixelGroup/HAT)

데이터 이미지의 최적화를 이용해 최근 개발된 HAT 기술을 이용하여 화질 개선 및 최적화
<br><br>**SR 프레임워크:**<br>

<img src="https://user-images.githubusercontent.com/94797349/205434782-6882510c-d995-4f4f-95a0-35bfad822156.png" width="600" height="350"/>
<br>

|<img src = "https://user-images.githubusercontent.com/94797349/204240451-e5e9578a-ae71-4d11-b520-277ffda8bba0.png" width="250" height="250"/>|<img src = "https://user-images.githubusercontent.com/94797349/204240451-e5e9578a-ae71-4d11-b520-277ffda8bba0.png" width="250" height="250"/>|
|--|--|
|데이터 이미지(Before SR)|데이터 이미지(After SR)|

<br>

<br>

> **최적화 후 객체 인식**

SR과 디노이징을 통한 최적화 후 객체 인식 테스트를 재진행한 결과, 아래의 표와 같이 화질 개선 이전에는 인식되지 않았던 객체가 최적화 후에는 인식되면서, 정확도가 높아짐을 확인할 수 있었음

|<img src = "https://user-images.githubusercontent.com/94797349/206855795-7db610f1-503b-48b2-9f62-c44d3527c81e.png" width="250" height="150"/>|<img src = "https://user-images.githubusercontent.com/94797349/206855813-9461f66a-90c2-4563-80bf-baaed89795dd.png" width="250" height="150"/>|
|--|--|
|데이터 이미지(Before SR)|데이터 이미지(After SR)|

<br>

# WebSite HI:M  
🌟**HI:M**
<br>High quality:IMage<br>

> 연구 과정에서 사용한 디노이징과 SR을 활용한 화질개선 웹사이트


<div align="center">
    
<img src = "https://user-images.githubusercontent.com/94797349/206855522-655a2acb-7664-485d-a4c0-5e75970a0f31.png" width="500" height="300"/>

</div>

🌟**Purpose**<br><br>
> 1. 깔끔한 디자인의 화질 개선 웹 사이트 개발
<br> 2. 일반 사용자: SNS 업로드, 리뷰 작성 등 고화질의 이미지를 필요로 하는 업무에 이용
<br> 3. 데이터셋 구축: 데이터로 사용할 이미지 파일 화질 개선<br>


<br><br><br>
<a href="https://drive.google.com/file/d/1CtBl-WSTkDsyFcMMNTLSv65IHZAVuDa0/view?usp=share_link">시연영상</a>
## FrontEnd
      [<img src="https://user-images.githubusercontent.com/94797349/203263241-95cb7160-0a81-4bc7-ae12-0ad275a40b60.png" width="100" height="150"/>](https://www.figma.com/files/recent?fuid=1158726737653483793)              [<img src="https://user-images.githubusercontent.com/94797349/203263379-dab35c9f-8284-44dc-9a2f-e18d51c38a7d.png" width="120" height="150"/>](https://developer.mozilla.org/ko/docs/Web/CSS)              [<img src="https://user-images.githubusercontent.com/94797349/203263442-e8c75941-9733-4723-988d-fa0c116fa5c4.png" width="140" height="150"/>](https://developer.mozilla.org/ko/docs/Learn/HTML/Introduction_to_HTML/Getting_started)

<br><br><br>

## BackEnd
                                                            
               [<img src="https://user-images.githubusercontent.com/94797349/205436530-72d1b647-6d97-4498-9af2-cba5e446e58f.png" width="150" height="150"/>](https://www.djangoproject.com/)              [<img src="https://user-images.githubusercontent.com/94797349/205434462-0fdbbe9e-b77f-48ee-b835-da8f31b57200.png" width="200" height="100"/>](https://opentutorials.org/course/4904)
  
  

# conference

  > 회의록 : [회의록 DRIVE](https://docs.google.com/document/d/1fIRLpuA7V0Jb0l6fWg8KfU0ae6wXg9rNU_Z_M0-um4E/edit?usp=sharing)

<br>
