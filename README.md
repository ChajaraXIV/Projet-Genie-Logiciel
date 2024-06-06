# Projet-Genie-Logiciel

# Gestion de Bornes de Recharge

## Description

Ce projet est une application de gestion de bornes de recharge pour les véhicules électriques..

## Structure du Projet

Le projet est structuré en plusieurs classes principales :

- **BorneDeRecharge** : Représente une borne de recharge avec un ID et un état (disponible, réservée, occupée).
- **Client** : Représente un client avec ses informations personnelles et ses véhicules.
- **Vehicule** : Représente un véhicule avec un numéro d'immatriculation.
- **Reservation** : Gère les réservations des bornes de recharge.
- **BdBorne** : Base de données simulée pour les bornes de recharge.
- **BdClient** : Base de données simulée pour les clients.
- **BdReservation** : Base de données simulée pour les réservations.
- **BdVehicule** : Base de données simulée pour les véhicules.
- **Main** : Classe ou on affiche le menu.

## Fonctionnalités du Projet
# Gestion des Clients

    Enregistrer un nouveau client
        Permet d'enregistrer un client en fournissant ses informations personnelles (nom, prénom, adresse, numéro de mobile, email, numéro de carte de débit) et ses véhicules.
        Vérifie la validité des informations fournies (numéro de téléphone, email, numéro de carte de débit).
        Empêche l'enregistrement de clients avec des informations déjà existantes (email, numéro de mobile).

    Afficher les clients enregistrés
        Affiche tous les clients enregistrés avec leurs informations personnelles et leurs véhicules.

    Vérifier l'existence d'un client par numéro de mobile ou numéro d'immatriculation
        Permet de vérifier si un client existe dans la base de données en utilisant son numéro de mobile ou le numéro d'immatriculation de son véhicule.

# Gestion des Véhicules

    Ajouter un véhicule pour un client existant
        Permet d'ajouter un nouveau véhicule pour un client existant.

    Trouver un véhicule par son numéro d'immatriculation
        Permet de rechercher et de trouver un véhicule en utilisant son numéro d'immatriculation.

# Gestion des Bornes de Recharge

    Initialiser les bornes de recharge
        Initialise une liste de bornes de recharge avec des états définis (disponible, réservée, occupée).

    Enregistrer une nouvelle borne de recharge
        Permet d'ajouter une nouvelle borne de recharge à la base de données.

    Rechercher une borne de recharge par ID
        Permet de rechercher et de trouver une borne de recharge en utilisant son ID.

    Trouver une borne de recharge disponible
        Permet de trouver une borne de recharge qui est actuellement disponible.

# Gestion des Réservations

    Faire une réservation
        Permet de réserver une borne de recharge pour un véhicule en utilisant le numéro d'immatriculation ou le numéro de mobile du client.
        Vérifie si le client et le véhicule existent dans la base de données.
        Enregistre la réservation avec les informations du client, du véhicule, de la borne de recharge, et les horaires de début et de fin de la réservation.
        Change l'état de la borne de recharge à "réservée".

    Afficher les réservations
        Affiche toutes les réservations existantes avec les détails du client, du véhicule, de la borne de recharge, et les horaires de début et de fin de la réservation.

    Gérer la période d'attente pour les réservations
        Si un client ne se présente pas au début de son créneau réservé, la borne de recharge est maintenue réservée pendant une "période d'attente" (par exemple, dix minutes).
        Si le client se présente pendant la période d'attente, il peut utiliser la borne réservée et sera facturé pour la totalité de la période réservée.
        Propose au client de payer un supplément pour maintenir la réservation de la borne au-delà du délai d'attente habituel (si la borne est disponible après l’horaire de fin).

## Interface Utilisateur (Console)

    Afficher le menu principal
        Affiche un menu interactif permettant de sélectionner les différentes fonctionnalités disponibles :
            Enregistrer un nouveau client
            Afficher les clients enregistrés
            Faire une réservation
            Afficher les réservations
            Quitter l'application

    Interagir avec l'utilisateur via la console
        Permet à l'utilisateur d'entrer des informations et de naviguer dans le menu principal.

## Prérequis

- Java JDK 8 ou supérieur
- Maven

## Installation

Clonez le projet depuis le dépôt GitHub :

    git clone https://github.com/ChajaraXIV/Projet-Genie-Logiciel﻿
    
## Remarque

Pour avoir les fonctionnalités d'administration, il faut entrer le mot de passe admin.
