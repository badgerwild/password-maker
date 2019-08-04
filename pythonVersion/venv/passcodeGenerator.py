import random
import os

# creates a number for selecting the word


def word_selector(n):
    n = int(n)
    select = ""
    for x in range(0, n):
        select += str(random.randint(1, 6))
    return select
    print(select)

        
def random_generator():
    word_list=''
    words = ''
    number_of_dice = input("Would you like to use 4 or 5 dice?")
    number_of_words = input("How many words would you like?")
    if int(number_of_dice) == 4:
        words = open("/home/badger/word-lists/eff_short_wordlist.txt", 'r')
    elif int(number_of_dice) == 5:
        words = open("/home/badger/word-lists/eff_large_wordlist.txt", 'r')
    word_list = [line.rstrip() for line in words]
    words.close()
# the number string to match the random number on the word list
    number_match = word_selector(number_of_dice)
# debug to make sure that everything is working
    print(word_list)
    for x in word_list:
        
    print(x)










if __name__ == '__main__':
    random_generator()

