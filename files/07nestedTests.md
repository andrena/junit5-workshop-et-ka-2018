# Nested Tests

Es gibt immer wieder Test-Setups die aufeinander aufbauen. Unser Library-Manager beispielsweise hat verschiedene Zustände (keine Bücher, alle vorhanden, einige ausgeliehen). Um all diese zu Testen gibt verschiedene Möglichkeiten:

- Für jeden Zustand eine eigene Testklasse (kann setup-Code duplizieren)
- Helper-Methoden, die vor jedem Test den gewünschten Zustand herstellen.
- In Junit4 den ``HierarchicalContextRunner`` als plugin (erlaubt aufeinander aufbauende Testklassen)

In JUnit5 ist dieser ``HierarchicalContextRunner`` in die Core-Library aufgenommen worden. Diesen wollen wir nun einmal ausprobieren.

## Aufgabe

Schreibe die Testklasse ``NestedTest`` um. Nutze hierzu die ``@Nested``-Annotation, um Test-Setup nicht wiederholen zu müssen. [NestedTests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-nested)

## Beispiel

```
@DisplayName("A stack")
class TestingAStackDemo {

	Stack<Object> stack;

	@BeforeEach
	void createNewStack() {
		stack = new Stack<>();
	}

	@Test
	@DisplayName("is empty")
	void isEmpty() {
		assertTrue(stack.isEmpty());
	}

	@Test
	@DisplayName("throws EmptyStackException when popped")
	void throwsExceptionWhenPopped() {
		assertThrows(EmptyStackException.class, () -> stack.pop());
	}

	@Nested
	@DisplayName("after pushing an element")
	class AfterPushing {

		String anElement = "an element";

		@BeforeEach
		void pushAnElement() {
			stack.push(anElement);
		}

		@Test
		@DisplayName("it is no longer empty")
		void isNotEmpty() {
			assertFalse(stack.isEmpty());
		}

		@Test
		@DisplayName("returns the element when popped and is empty")
		void returnElementWhenPopped() {
			assertEquals(anElement, stack.pop());
			assertTrue(stack.isEmpty());
		}
	}
}

```
