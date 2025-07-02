hotel-booking-app/</br>
├── src/</br>
│   ├── main/</br>
│   │   ├── java/</br>
│   │   │   └── com/</br>
│   │   │       └── yourcompany/</br>
│   │   │           └── hotelbooking/</br>
│   │   │               ├── HotelBookingApplication.java</br>
│   │   │</br>
│   │   │               ├── config/                 ← JWT, CORS, Swagger config</br>
│   │   │               │   ├── JwtConfig.java</br>
│   │   │               │   ├── SecurityConfig.java</br>
│   │   │</br>
│   │   │               ├── controller/             ← REST controllers</br>
│   │   │               │   ├── AuthController.java</br>
│   │   │               │   ├── HotelController.java</br>
│   │   │               │   ├── RoomController.java</br>
│   │   │               │   ├── BookingController.java</br>
│   │   │</br>
│   │   │               ├── dto/                    ← Request/response models</br>
│   │   │               │   ├── RegisterRequest.java</br>
│   │   │               │   ├── BookingResponse.java</br>
│   │   │</br>
│   │   │               ├── entity/                 ← JPA entities (tables)</br>
│   │   │               │   ├── User.java</br>
│   │   │               │   ├── Hotel.java</br>
│   │   │               │   ├── Room.java</br>
│   │   │               │   ├── Booking.java</br>
│   │   │</br>
│   │   │               ├── repository/             ← JPA repositories</br>
│   │   │               │   ├── UserRepository.java</br>
│   │   │               │   ├── HotelRepository.java</br>
│   │   │               │   ├── RoomRepository.java</br>
│   │   │               │   ├── BookingRepository.java</br>
│   │   │</br>
│   │   │               ├── service/                ← Business logic</br>
│   │   │               │   ├── UserService.java</br>
│   │   │               │   ├── HotelService.java</br>
│   │   │               │   ├── BookingService.java</br>
│   │   │</br>
│   │   │               ├── exception/              ← Custom exception handlers</br>
│   │   │               │   ├── GlobalExceptionHandler.java</br>
│   │   │               │   ├── ResourceNotFoundException.java</br>
│   │   │</br>
│   │   │               └── util/                   ← Utility classes/helpers</br>
│   │   │                   ├── JwtUtil.java</br>
│   │   │                   ├── DateUtil.java</br>
│   │   │</br>
│   │   └── resources/</br>
│   │       ├── application.properties</br>
│   │       └── static/        ← (optional)</br>
│   │       └── templates/     ← (if using Thymeleaf)</br>
│</br>
│   └── test/                  ← Unit & integration tests</br>
│       └── java/</br>
│           └── com/yourcompany/hotelbooking/</br>
│               ├── BookingServiceTest.java</br>
│               └── UserControllerTest.java</br>
│</br>
├── pom.xml                    ← Maven dependencies</br>
└── README.md</br>
