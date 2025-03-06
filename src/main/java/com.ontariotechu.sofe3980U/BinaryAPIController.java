package com.ontariotechu.sofe3980U;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BinaryAPIController {

	@GetMapping("/add")
	public String addString(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
							@RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return Binary.add(number1, number2).getValue();
	}

	@GetMapping("/add_json")
	public BinaryAPIResult addJSON(@RequestParam(name = "operand1", required = false) String operand1,
								   @RequestParam(name = "operand2", required = false) String operand2) {
		if (operand1 == null || operand1.isEmpty() || operand2 == null || operand2.isEmpty()) {
			throw new IllegalArgumentException("Both operands are required");
		}
		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return new BinaryAPIResult(number1, "add", number2, Binary.add(number1, number2));
	}

	@GetMapping("/multiply_json")
	public ResponseEntity<Binary> multiplyBinary(@RequestParam String operand1, @RequestParam String operand2) {
		Binary num1 = new Binary(operand1);
		Binary num2 = new Binary(operand2);
		Binary result = Binary.multiply(num1, num2);
		return ResponseEntity.ok(result);
	}


	// Exception handler to return a 400 Bad Request status for missing operands
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleInvalidInput(IllegalArgumentException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
