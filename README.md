# TestProduct

1. com.example.demo package contains SpringBoot REST POST controller to validate product

{
  "seller":"123534251",
  "customer":"648563524",
  "products":[
    {"name":"milk","code":"2364758363546"},
    {"name":"water","code":"3656352437590"}
  ]
}

Validations:
  все поля обязательны. Идентификатор seller/customer - строка 9 символов,
  идентификатор продукта - строка 13 символов.
  
  
 2. com.example.threadsafetest package contain thread-safe ThreadSafeComputer class and MainThreadSafeComputer to test it
