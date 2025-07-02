hotel-booking-app/</br>
│</br>
├── 📁 src/</br>
│   ├── 📁 main/</br>
│   │   ├── 📁 java/</br>
│   │   │   └── 📁 com/</br>
│   │   │       └── 📁 yourcompany/</br>
│   │   │           └── 📁 hotelbooking/</br>
│   │   │               │</br>
│   │   │               ├── 📄 HotelBookingApplication.java</br>
│   │   │               │</br>
│   │   │               ├── 📁 config/                    ← Configuration classes</br>
│   │   │               │   ├── 📄 SecurityConfig.java</br>
│   │   │               │   ├── 📄 JwtConfig.java</br>
│   │   │               │   ├── 📄 CorsConfig.java</br>
│   │   │               │   ├── 📄 SwaggerConfig.java</br>
│   │   │               │   ├── 📄 DatabaseConfig.java</br>
│   │   │               │   └── 📄 WebConfig.java</br>
│   │   │               │</br>
│   │   │               ├── 📁 controller/                ← REST API endpoints</br>
│   │   │               │   ├── 📁 auth/</br>
│   │   │               │   │   ├── 📄 AuthController.java</br>
│   │   │               │   │   └── 📄 UserController.java</br>
│   │   │               │   │</br>
│   │   │               │   ├── 📁 hotel/</br>
│   │   │               │   │   ├── 📄 HotelController.java</br>
│   │   │               │   │   ├── 📄 RoomController.java</br>
│   │   │               │   │   └── 📄 AmenityController.java</br>
│   │   │               │   │</br>
│   │   │               │   ├── 📁 booking/</br>
│   │   │               │   │   ├── 📄 BookingController.java</br>
│   │   │               │   │   ├── 📄 PaymentController.java</br>
│   │   │               │   │   └── 📄 ReservationController.java</br>
│   │   │               │   │</br>
│   │   │               │   └── 📁 admin/</br>
│   │   │               │       ├── 📄 AdminController.java</br>
│   │   │               │       ├── 📄 DashboardController.java</br>
│   │   │               │       └── 📄 ReportsController.java</br>
│   │   │               │</br>
│   │   │               ├── 📁 dto/                       ← Data Transfer Objects</br>
│   │   │               │   ├── 📁 request/</br>
│   │   │               │   │   ├── 📄 RegisterRequest.java</br>
│   │   │               │   │   ├── 📄 LoginRequest.java</br>
│   │   │               │   │   ├── 📄 BookingRequest.java</br>
│   │   │               │   │   ├── 📄 HotelCreateRequest.java</br>
│   │   │               │   │   └── 📄 RoomSearchRequest.java</br>
│   │   │               │   │</br>
│   │   │               │   ├── 📁 response/</br>
│   │   │               │   │   ├── 📄 ApiResponse.java</br>
│   │   │               │   │   ├── 📄 AuthResponse.java</br>
│   │   │               │   │   ├── 📄 BookingResponse.java</br>
│   │   │               │   │   ├── 📄 HotelResponse.java</br>
│   │   │               │   │   ├── 📄 RoomResponse.java</br>
│   │   │               │   │   └── 📄 UserResponse.java</br>
│   │   │               │   │</br>
│   │   │               │   └── 📁 common/</br>
│   │   │               │       ├── 📄 PageResponse.java</br>
│   │   │               │       ├── 📄 ErrorResponse.java</br>
│   │   │               │       └── 📄 SuccessResponse.java</br>
│   │   │               │</br>
│   │   │               ├── 📁 entity/                    ← JPA Entities (Database Tables)</br>
│   │   │               │   ├── 📁 user/</br>
│   │   │               │   │   ├── 📄 User.java</br>
│   │   │               │   │   ├── 📄 Role.java</br>
│   │   │               │   │   └── 📄 UserProfile.java</br>
│   │   │               │   │</br>
│   │   │               │   ├── 📁 hotel/</br>
│   │   │               │   │   ├── 📄 Hotel.java</br>
│   │   │               │   │   ├── 📄 Room.java</br>
│   │   │               │   │   ├── 📄 RoomType.java</br>
│   │   │               │   │   ├── 📄 Amenity.java</br>
│   │   │               │   │   └── 📄 HotelImage.java</br>
│   │   │               │   │</br>
│   │   │               │   ├── 📁 booking/</br>
│   │   │               │   │   ├── 📄 Booking.java</br>
│   │   │               │   │   ├── 📄 Payment.java</br>
│   │   │               │   │   ├── 📄 Reservation.java</br>
│   │   │               │   │   └── 📄 BookingStatus.java</br>
│   │   │               │   │</br>
│   │   │               │   └── 📁 common/</br>
│   │   │               │       ├── 📄 BaseEntity.java</br>
│   │   │               │       └── 📄 Address.java</br>
│   │   │               │</br>
│   │   │               ├── 📁 repository/                ← Data Access Layer</br>
│   │   │               │   ├── 📁 user/</br>
│   │   │               │   │   ├── 📄 UserRepository.java</br>
│   │   │               │   │   ├── 📄 RoleRepository.java</br>
│   │   │               │   │   └── 📄 UserProfileRepository.java</br>
│   │   │               │   │</br>
│   │   │               │   ├── 📁 hotel/</br>
│   │   │               │   │   ├── 📄 HotelRepository.java</br>
│   │   │               │   │   ├── 📄 RoomRepository.java</br>
│   │   │               │   │   ├── 📄 RoomTypeRepository.java</br>
│   │   │               │   │   └── 📄 AmenityRepository.java</br>
│   │   │               │   │</br>
│   │   │               │   └── 📁 booking/</br>
│   │   │               │       ├── 📄 BookingRepository.java</br>
│   │   │               │       ├── 📄 PaymentRepository.java</br>
│   │   │               │       └── 📄 ReservationRepository.java</br>
│   │   │               │</br>
│   │   │               ├── 📁 service/                   ← Business Logic Layer</br>
│   │   │               │   ├── 📁 auth/</br>
│   │   │               │   │   ├── 📄 AuthService.java</br>
│   │   │               │   │   ├── 📄 AuthServiceImpl.java</br>
│   │   │               │   │   ├── 📄 UserService.java</br>
│   │   │               │   │   ├── 📄 UserServiceImpl.java</br>
│   │   │               │   │   └── 📄 JwtService.java</br>
│   │   │               │   │</br>
│   │   │               │   ├── 📁 hotel/</br>
│   │   │               │   │   ├── 📄 HotelService.java</br>
│   │   │               │   │   ├── 📄 HotelServiceImpl.java</br>
│   │   │               │   │   ├── 📄 RoomService.java</br>
│   │   │               │   │   ├── 📄 RoomServiceImpl.java</br>
│   │   │               │   │   └── 📄 SearchService.java</br>
│   │   │               │   │</br>
│   │   │               │   ├── 📁 booking/</br>
│   │   │               │   │   ├── 📄 BookingService.java</br>
│   │   │               │   │   ├── 📄 BookingServiceImpl.java</br>
│   │   │               │   │   ├── 📄 PaymentService.java</br>
│   │   │               │   │   ├── 📄 PaymentServiceImpl.java</br>
│   │   │               │   │   └── 📄 NotificationService.java</br>
│   │   │               │   │</br>
│   │   │               │   └── 📁 admin/</br>
│   │   │               │       ├── 📄 AdminService.java</br>
│   │   │               │       ├── 📄 ReportService.java</br>
│   │   │               │       └── 📄 AnalyticsService.java</br>
│   │   │               │</br>
│   │   │               ├── 📁 security/                  ← Security Implementation</br>
│   │   │               │   ├── 📄 JwtAuthenticationFilter.java</br>
│   │   │               │   ├── 📄 JwtAuthenticationProvider.java</br>
│   │   │               │   ├── 📄 UserDetailsServiceImpl.java</br>
│   │   │               │   └── 📄 SecurityUtils.java</br>
│   │   │               │</br>
│   │   │               ├── 📁 exception/                 ← Exception Handling</br>
│   │   │               │   ├── 📄 GlobalExceptionHandler.java</br>
│   │   │               │   ├── 📄 ResourceNotFoundException.java</br>
│   │   │               │   ├── 📄 BookingException.java</br>
│   │   │               │   ├── 📄 PaymentException.java</br>
│   │   │               │   ├── 📄 UnauthorizedException.java</br>
│   │   │               │   └── 📄 ValidationException.java</br>
│   │   │               │</br>
│   │   │               ├── 📁 util/                      ← Utility Classes</br>
│   │   │               │   ├── 📄 JwtUtil.java</br>
│   │   │               │   ├── 📄 DateUtil.java</br>
│   │   │               │   ├── 📄 ValidationUtil.java</br>
│   │   │               │   ├── 📄 EmailUtil.java</br>
│   │   │               │   ├── 📄 FileUtil.java</br>
│   │   │               │   └── 📄 CacheUtil.java</br>
│   │   │               │</br>
│   │   │               ├── 📁 validation/                ← Custom Validators</br>
│   │   │               │   ├── 📄 BookingDateValidator.java</br>
│   │   │               │   ├── 📄 EmailValidator.java</br>
│   │   │               │   └── 📄 PhoneValidator.java</br>
│   │   │               │</br>
│   │   │               ├── 📁 mapper/                    ← Entity-DTO Mappers</br>
│   │   │               │   ├── 📄 UserMapper.java</br>
│   │   │               │   ├── 📄 HotelMapper.java</br>
│   │   │               │   ├── 📄 BookingMapper.java</br>
│   │   │               │   └── 📄 RoomMapper.java</br>
│   │   │               │</br>
│   │   │               └── 📁 constants/                 ← Application Constants</br>
│   │   │                   ├── 📄 ApiConstants.java</br>
│   │   │                   ├── 📄 SecurityConstants.java</br>
│   │   │                   ├── 📄 BookingStatus.java</br>
│   │   │                   └── 📄 PaymentStatus.java</br>
│   │   │</br>
│   │   └── 📁 resources/</br>
│   │       ├── 📄 application.properties</br>
│   │       ├── 📄 application-dev.properties</br>
│   │       ├── 📄 application-prod.properties</br>
│   │       ├── 📄 application-test.properties</br>
│   │       │</br>
│   │       ├── 📁 db/</br>
│   │       │   └── 📁 migration/                        ← Database migrations</br>
│   │       │       ├── 📄 V1__Create_users_table.sql</br>
│   │       │       ├── 📄 V2__Create_hotels_table.sql</br>
│   │       │       ├── 📄 V3__Create_rooms_table.sql</br>
│   │       │       └── 📄 V4__Create_bookings_table.sql</br>
│   │       │</br>
│   │       ├── 📁 static/                               ← Static files</br>
│   │       │   ├── 📁 css/</br>
│   │       │   ├── 📁 js/</br>
│   │       │   └── 📁 images/</br>
│   │       │</br>
│   │       └── 📁 templates/                            ← Email templates</br>
│   │           ├── 📄 booking-confirmation.html</br>
│   │           ├── 📄 welcome-email.html</br>
│   │           └── 📄 password-reset.html</br>
│   │</br>
│   └── 📁 test/</br>
│       └── 📁 java/</br>
│           └── 📁 com/yourcompany/hotelbooking/</br>
│               │</br>
│               ├── 📁 integration/                      ← Integration tests</br>
│               │   ├── 📄 AuthControllerIntegrationTest.java</br>
│               │   ├── 📄 BookingControllerIntegrationTest.java</br>
│               │   └── 📄 HotelControllerIntegrationTest.java</br>
│               │</br>
│               ├── 📁 unit/                             ← Unit tests</br>
│               │   ├── 📁 service/</br>
│               │   │   ├── 📄 BookingServiceTest.java</br>
│               │   │   ├── 📄 UserServiceTest.java</br>
│   │   │   │   │   └── 📄 HotelServiceTest.java</br>
│   │   │               │   │</br>
│   │   │               │   ├── 📁 controller/</br>
│   │   │               │   │   ├── 📄 UserControllerTest.java</br>
│   │   │               │   │   └── 📄 BookingControllerTest.java</br>
│   │   │               │   │</br>
│   │   │               │   └── 📁 repository/</br>
│   │   │               │       ├── 📄 UserRepositoryTest.java</br>
│   │   │               │       └── 📄 BookingRepositoryTest.java</br>
│   │   │               │</br>
│   │   │               └── 📁 testdata/                         ← Test data fixtures</br>
│   │   │                   ├── 📄 TestDataBuilder.java</br>
│   │   │                   └── 📄 MockDataProvider.java</br>
│   │   │</br>
│   └── 📁 test/</br>
│       └── 📁 java/</br>
│           └── 📁 com/yourcompany/hotelbooking/</br>
│               │</br>
│               ├── 📁 integration/                      ← Integration tests</br>
│               │   ├── 📄 AuthControllerIntegrationTest.java</br>
│               │   ├── 📄 BookingControllerIntegrationTest.java</br>
│               │   └── 📄 HotelControllerIntegrationTest.java</br>
│               │</br>
│               ├── 📁 unit/                             ← Unit tests</br>
│               │   ├── 📁 service/</br>
│               │   │   ├── 📄 BookingServiceTest.java</br>
│               │   │   ├── 📄 UserServiceTest.java</br>
│   │   │   │   │   └── 📄 HotelServiceTest.java</br>
│   │   │               │   │</br>
│   │   │               │   ├── 📁 controller/</br>
│   │   │               │   │   ├── 📄 UserControllerTest.java</br>
│   │   │               │   │   └── 📄 BookingControllerTest.java</br>
│   │   │               │   │</br>
│   │   │               │   └── 📁 repository/</br>
│   │   │               │       ├── 📄 UserRepositoryTest.java</br>
│   │   │               │       └── 📄 BookingRepositoryTest.java</br>
│   │   │               │</br>
│   │   │               └── 📁 testdata/                         ← Test data fixtures</br>
│   │   │                   ├── 📄 TestDataBuilder.java</br>
│   │   │                   └── 📄 MockDataProvider.java</br>
│</br>
├── 📁 docs/                                            ← Documentation</br>
│   ├── 📄 API.md</br>
│   ├── 📄 DATABASE.md</br>
│   ├── 📄 DEPLOYMENT.md</br>
│   └── 📁 postman/</br>
│       └── 📄 hotel-booking-api.postman_collection.json</br>
│</br>
├── 📁 scripts/                                         ← Utility scripts</br>
│   ├── 📄 setup-db.sh</br>
│   ├── 📄 deploy.sh</br>
│   └── 📄 backup-db.sh</br>
│</br>
├── 📁 docker/                                          ← Docker configuration</br>
│   ├── 📄 Dockerfile</br>
│   ├── 📄 docker-compose.yml</br>
│   └── 📄 docker-compose.prod.yml</br>
│</br>
├── 📄 pom.xml                                          ← Maven dependencies</br>
├── 📄 README.md                                        ← Project overview</br>
├── 📄 .gitignore                                       ← Git ignore rules</br>
├── 📄 .env.example                                     ← Environment variables template</br>
├── 📄 LICENSE                                          ← Project license</br>
└── 📄 CHANGELOG.md                                     ← Version history</br>