hotel-booking-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── yourcompany/
│   │   │           └── hotelbooking/
│   │   │               ├── HotelBookingApplication.java
│   │   │
│   │   │               ├── config/                 ← JWT, CORS, Swagger config
│   │   │               │   ├── JwtConfig.java
│   │   │               │   ├── SecurityConfig.java
│   │   │
│   │   │               ├── controller/             ← REST controllers
│   │   │               │   ├── AuthController.java
│   │   │               │   ├── HotelController.java
│   │   │               │   ├── RoomController.java
│   │   │               │   ├── BookingController.java
│   │   │
│   │   │               ├── dto/                    ← Request/response models
│   │   │               │   ├── RegisterRequest.java
│   │   │               │   ├── BookingResponse.java
│   │   │
│   │   │               ├── entity/                 ← JPA entities (tables)
│   │   │               │   ├── User.java
│   │   │               │   ├── Hotel.java
│   │   │               │   ├── Room.java
│   │   │               │   ├── Booking.java
│   │   │
│   │   │               ├── repository/             ← JPA repositories
│   │   │               │   ├── UserRepository.java
│   │   │               │   ├── HotelRepository.java
│   │   │               │   ├── RoomRepository.java
│   │   │               │   ├── BookingRepository.java
│   │   │
│   │   │               ├── service/                ← Business logic
│   │   │               │   ├── UserService.java
│   │   │               │   ├── HotelService.java
│   │   │               │   ├── BookingService.java
│   │   │
│   │   │               ├── exception/              ← Custom exception handlers
│   │   │               │   ├── GlobalExceptionHandler.java
│   │   │               │   ├── ResourceNotFoundException.java
│   │   │
│   │   │               └── util/                   ← Utility classes/helpers
│   │   │                   ├── JwtUtil.java
│   │   │                   ├── DateUtil.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/        ← (optional)
│   │       └── templates/     ← (if using Thymeleaf)
│
│   └── test/                  ← Unit & integration tests
│       └── java/
│           └── com/yourcompany/hotelbooking/
│               ├── BookingServiceTest.java
│               └── UserControllerTest.java
│
├── pom.xml                    ← Maven dependencies
└── README.md
