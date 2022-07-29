package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n----------> Executing @Before advice on addAccount()");
	}

	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n----------> performing Api Analytics method");

	}

// Quand on combine des expressions pointcut on utilise les opérateurs logiques
// && (et), || (ou), et && !sdfg(ne pas). L'expression s'execute quand ça retourne
// "true" (pour "et" les deux conditions doivent être bon, pour "ou" l'une des
// deux doit être bon pour retourner "true", etc.) On va le mettre en pratique
// en appliquant une déclaration sur tout SAUF les getters et setters.

	// 1. créer DPC à combiner (ici: une pour "set" et une pour "get")
	// 2. combiner les nouvelles DPC avec la première
	// 3. appliquer DPC aux advices

}
