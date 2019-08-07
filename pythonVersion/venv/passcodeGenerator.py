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

        
def random_generator(dice):
    word_list = []
    words = ''
    if int(dice) == 4:
        words = open("/home/badger/word-lists/eff_short_wordlist.txt", 'r')
    elif int(dice) == 5:
        words = open("/home/badger/word-lists/eff_large_wordlist.txt", 'r')
    for word in words.read().split():
        word_list.append(word)
    words.close()
# the number string to match the random number on the word list
    number_match = word_selector(dice)
    index_tracker = 0
    for idx, val in enumerate(word_list):
        if val == number_match:
            index_tracker = int(idx)+1
    return word_list[index_tracker]


if __name__ == '__main__':
    number_of_dice = input("Would you like to use 4 or 5 dice?")
    number_of_words = input("How many words would you like?")

    the_passcode = ''

    for x in range(0, int(number_of_words)):
        the_passcode += random_generator(number_of_dice)

    print(the_passcode)